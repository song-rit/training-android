package th.ac.sut.gson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.HttpGet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import th.ac.sut.gson.adapter.ListViewCustomAdapter;
import th.ac.sut.gson.model.Blog;
import th.ac.sut.gson.model.Post;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http://blog.teamtreehouse.com/api/get_recent_summary/";
    private ListView listView;
    private ListViewCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();

        new SimpleTask().execute(URL);
    }

    private void infixView() {
        listView = (ListView) findViewById(R.id.list_view);
    }

    private class SimpleTask extends AsyncTask<String, Void, String> {

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
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String JSONString) {

            super.onPostExecute(JSONString);
            showData(JSONString);
        }
    }

    private void showData(String JSONString) {

        Gson gson = new Gson();
        Blog blog = gson.fromJson(JSONString, Blog.class);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.setLength(0);

        List<Post> posts = blog.getPosts();

        /*for (Post post : posts) {
            stringBuilder.append(post.getTitle());
        }*/
//        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();

        customAdapter = new ListViewCustomAdapter(this, posts);
        listView.setAdapter(customAdapter);


    }
}

