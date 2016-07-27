package th.ac.sut.asynctask;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.HttpGet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button buttonOK;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();

        url.setHint("http://www.google.com");

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleTast().execute(url.getText().toString().trim());
            }
        });
    }

    private void updateWebView(String result) {

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(result, "text/html; charset=utf-8", "utf-8");
    }


    private class SimpleTast extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";

            try {
                HttpGet httpGet = new HttpGet(urls[0]);
                HttpClient client = new DefaultHttpClient();
                HttpResponse response = client.execute(httpGet);

                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == 200) {
                    InputStream inputStream = response.getEntity().getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        result += line;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            updateWebView(s);
        }
    }

    private void infixView() {
        url = (EditText) findViewById(R.id.edit_text_url);
        buttonOK = (Button) findViewById(R.id.button_ok);
        webView = (WebView) findViewById(R.id.web_view_content);
    }
}
