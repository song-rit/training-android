package th.ac.sut.basic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nirvana on 13/3/2559.
 */
public class Second extends Activity {

    private Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        infixView();
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    private void infixView() {
        buttonBack = (Button) findViewById(R.id.buttonBack);
    }
}
