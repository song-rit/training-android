package th.ac.sut.okhttp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpGetBasic extends AppCompatActivity {

    String url = "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWMEV4X044Tm5OQkk&export=download";
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_basic);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    final String reposeString = HTTPGet2(url);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(OkHttpGetBasic.this, reposeString, Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        HTTPGet(url);
    }

    public void HTTPGet(final String url) {
        final StringBuffer responseString = new StringBuffer("");
        Thread thread = new Thread() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                super.run();
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder().url(url).build();
                try (Response response = client.newCall(request).execute()) {
                    responseString.append(response.body().string());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(OkHttpGetBasic.this, responseString.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    String HTTPGet2(final String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
