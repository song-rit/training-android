package th.ac.sut.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import th.ac.sut.sharedpreferences.app.Constant;
import th.ac.sut.sharedpreferences.model.Login;

public class SecondActivity extends AppCompatActivity {

    TextView textViewName, textViewLastName, textViewMajor, textViewUniversity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        infixView();
        SharedPreferences sp = getSharedPreferences(Constant.SharePreference.LOG_IN, MODE_PRIVATE);
        String name = sp.getString(Constant.SharePreference.NAME, "");
        String lastName = sp.getString(Constant.SharePreference.LAST_NAME, "");
        String major = sp.getString(Constant.SharePreference.MAJOR, "");
        String university = sp.getString(Constant.SharePreference.UNIVERSITY, "");

        textViewName.setText(name);
        textViewLastName.setText(lastName);
        textViewMajor.setText(major);
        textViewUniversity.setText(university);
    }

    private void infixView() {
        textViewName = (TextView) findViewById(R.id.text_view_name);
        textViewLastName = (TextView) findViewById(R.id.text_view_last_name);
        textViewMajor = (TextView) findViewById(R.id.text_view_major);
        textViewUniversity = (TextView) findViewById(R.id.text_view_university);
    }
}
