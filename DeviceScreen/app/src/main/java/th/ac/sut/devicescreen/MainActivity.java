package th.ac.sut.devicescreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();

        int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
        resolution.setText(String.valueOf(screenWidth) + " x " + String.valueOf(screenHeight));


    }

    private void infixView() {
        resolution = (TextView) findViewById(R.id.text_view_resolution);
    }
}
