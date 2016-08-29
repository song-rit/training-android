package th.ac.sut.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import th.ac.sut.sharedpreferences.app.Constant;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences sp = getSharedPreferences(Constant.PREFS_LOGIN, MODE_PRIVATE);
        String name = sp.getString("name", "");
        Toast.makeText(SecondActivity.this, name, Toast.LENGTH_SHORT).show();
    }
}
