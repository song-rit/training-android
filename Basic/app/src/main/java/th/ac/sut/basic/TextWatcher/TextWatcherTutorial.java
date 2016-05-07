package th.ac.sut.basic.TextWatcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import th.ac.sut.basic.R;

public class TextWatcherTutorial extends AppCompatActivity {

    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_watcher_test);

        infixView();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                int count = 120 - editText.length();

                textView.setText(String.valueOf(count));

                textView.setTextColor(Color.GREEN);

                if (count < 20) {
                    textView.setTextColor(Color.RED);
                }

            }
        });
    }

    private void infixView() {
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
    }
}
