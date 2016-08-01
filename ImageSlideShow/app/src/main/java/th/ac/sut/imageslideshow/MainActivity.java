package th.ac.sut.imageslideshow;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import th.ac.sut.imageslideshow.fragment.ImageSlideFragment;
import th.ac.sut.imageslideshow.model.ImageModel;

public class MainActivity extends AppCompatActivity {

    private ImageModel imageModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageSlideFragment myFragment = ImageSlideFragment.newInstance("");

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_layout, myFragment);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(imageModel == null) {
            sendRequest();
        }
    }

    private void sendRequest() {

        Gson gson = new Gson();

    }
}
