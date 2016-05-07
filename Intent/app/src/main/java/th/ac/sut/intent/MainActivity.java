package th.ac.sut.intent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONStringer;

public class MainActivity extends AppCompatActivity {

    private Button buttonMainActivity;
    private TextView textViewMainActivity;
    private Context mainContext;

    String[] myData = {"jame", "jib", "jo"};
    String jsonString = "{\"family\": [\"jame\", \"jib\", \"jo\"] }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContext = getApplicationContext(); //แก้ปัญหาเวลาเรียก Activity ใน AnonymousInnerClass

        infixView();

        buttonMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //Intent intent = new Intent(getActivity(), AboutActivity.class); //แก้ปัญหาตอนเรียก Activity ใน Fragment
                Intent intent = new Intent(mainContext, SecondActivity.class);

                Gson gson = new Gson();
                JSONArray jsonArray = new JSONArray();
                intent.putExtra("data", myData);
                intent.putExtra("data2", jsonString);
                startActivity(intent);
            }
        });
    }

    private void infixView() {
        buttonMainActivity = (Button) findViewById(R.id.buttonMainActivity);
        textViewMainActivity = (TextView) findViewById(R.id.textViewMainActivity);
    }
}
