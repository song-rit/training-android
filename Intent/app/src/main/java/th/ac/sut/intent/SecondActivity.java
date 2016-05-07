package th.ac.sut.intent;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    private Button buttonSecondActivity;
    private TextView textViewSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        infixView();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String[] data = bundle.getStringArray("data");
            for(int i = 0 ; i < data.length; i++) {
                Log.d("data", data[i]);
            }
        }

        String jsonString = bundle.getString("data2");
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
            Log.d("family", String.valueOf(jsonObject.get("family")) );
            Toast.makeText(getApplicationContext(), "Family" + String.valueOf(jsonObject.get("family")), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void infixView() {
        buttonSecondActivity = (Button) findViewById(R.id.buttonSecondActivity);
        textViewSecondActivity = (TextView) findViewById(R.id.textViewSecondActivity);
    }
}
