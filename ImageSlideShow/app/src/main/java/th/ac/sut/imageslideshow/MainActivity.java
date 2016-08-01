package th.ac.sut.imageslideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String url = "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWMEV4X044Tm5OQkk&export=download";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
