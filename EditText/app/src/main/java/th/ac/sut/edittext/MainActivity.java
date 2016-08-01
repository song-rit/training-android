package th.ac.sut.edittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewName, textViewTel, textViewEmail;
    EditText editTextName, editTextTel, editTextEmail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();

        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewName.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewTel.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewEmail.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("textName", textViewName.getText());
                intent.putExtra("textTel", textViewTel.getText());
                intent.putExtra("textEmail", textViewEmail.getText());
                startActivity(intent);

            }
        });
    }

    private void infixView() {
        textViewName = (TextView) findViewById(R.id.text_view_name);
        textViewTel = (TextView) findViewById(R.id.text_view_tel);
        textViewEmail = (TextView) findViewById(R.id.text_view_email);
        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextTel = (EditText) findViewById(R.id.edit_text_tel);
        editTextEmail = (EditText) findViewById(R.id.edit_text_email);
        button = (Button) findViewById(R.id.button);
    }
}
