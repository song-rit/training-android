package th.ac.sut.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpGetBasic2 extends AppCompatActivity {

    String url = "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWMEV4X044Tm5OQkk&export=download";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_basic);
    }

    public String HTTPGetBuiltIn(String url) {
        final StringBuffer responseString = new StringBuffer("");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                responseString.append(response.body().string());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OkHttpGetBasic2.this, responseString.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return responseString.toString();
    }

    public void HTTPGetMyThread() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();

                try {
                    Response response = client.newCall(request).execute();
                    final String responseString = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(OkHttpGetBasic2.this, responseString.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }


}
