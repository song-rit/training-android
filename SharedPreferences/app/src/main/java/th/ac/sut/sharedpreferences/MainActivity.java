package th.ac.sut.sharedpreferences;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import th.ac.sut.sharedpreferences.app.Constant;
import th.ac.sut.sharedpreferences.model.Login;

public class MainActivity extends AppCompatActivity {

    private Button button;
    EditText editTextUserName;
    EditText editTextPassWord;
    private String userName;
    private String passWord;
    private ProgressDialog progress;



    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressShow();

                userName = editTextUserName.getText().toString();
                passWord = editTextPassWord.getText().toString();
                final StringBuffer responseString = new StringBuffer("");

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            final String responseString = HTTPGet2(Constant.URL_LOGIN);
                            Gson gson = new Gson();
                            final Login login = gson.fromJson(responseString.toString(), Login.class);
                            if (login.getStatus() && editTextUserName.getText().toString().equals(login.getUserName()) && editTextPassWord.getText().toString().equals(login.getPassWord())) {

                                SharedPreferences sp = getSharedPreferences(Constant.SharePreference.LOG_IN, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sp.edit();
                                editor.putString(Constant.SharePreference.NAME, login.getData().getName());
                                editor.putString(Constant.SharePreference.LAST_NAME, login.getData().getLastName());
                                editor.putString(Constant.SharePreference.MAJOR, login.getData().getLastName());
                                editor.putString(Constant.SharePreference.UNIVERSITY, login.getData().getUniversity());
                                editor.commit();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        progress.hide();
                                        Toast.makeText(MainActivity.this, "Log in Success", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "Log in Fail", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });
    }

    private void infixView() {
        button = (Button) findViewById(R.id.button_login);
        editTextPassWord = (EditText) findViewById(R.id.edit_text_password);
        editTextUserName = (EditText) findViewById(R.id.edit_text_username);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private String post(String url, String json) throws IOException {

        RequestBody body = RequestBody.create(Constant.JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    String HTTPGet2(final String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private void progressShow() {
        progress= new ProgressDialog(MainActivity.this);
        progress.setMessage("Waiting..");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCancelable(false);
        progress.setIndeterminate(true);
        progress.show();
    }
}
