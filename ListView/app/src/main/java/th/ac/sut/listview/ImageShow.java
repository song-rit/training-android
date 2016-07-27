package th.ac.sut.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import th.ac.sut.listview.model.Image;

public class ImageShow extends AppCompatActivity {

    Gson gson = new GsonBuilder().create();
    Image image = new Image();

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);

        infixView();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String JSONString = bundle.getString("JSON");
            image = gson.fromJson(JSONString, Image.class);

            imageView.setImageResource(image.getResourceId());
            textView.setText(image.getName());
        }
    }

    private void infixView() {
        imageView = (ImageView) findViewById(R.id.image_view_pic);
        textView = (TextView) findViewById(R.id.text_view_name);
    }
}
