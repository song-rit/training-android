package th.ac.sut.edittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textViewName, textViewTel, textViewEmail;
    String textName, textTel, textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        infixView();

        textName = getIntent().getExtras().getString("textName");
        textTel = getIntent().getExtras().getString("textTel");
        textEmail = getIntent().getExtras().getString("textEmail");

        textViewName.setText(textName);
        textViewTel.setText(textTel);
        textViewEmail.setText(textEmail);
    }

    private void infixView() {
        textViewName = (TextView) findViewById(R.id.text_view_name);
        textViewTel = (TextView) findViewById(R.id.text_view_tel);
        textViewEmail = (TextView) findViewById(R.id.text_view_email);
    }
}
