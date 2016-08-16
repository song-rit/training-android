package th.ac.sut.multiplescreensize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        int screenHeight  = getWindowManager().getDefaultDisplay().getHeight();

        Toast.makeText(MainActivity.this, String.valueOf(screenWidth) + "," + String.valueOf(screenHeight), Toast.LENGTH_SHORT).show();
    }
}
