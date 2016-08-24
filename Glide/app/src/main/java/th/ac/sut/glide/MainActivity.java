package th.ac.sut.glide;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import th.ac.sut.glide.adapter.GridViewAdapter;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();
        activity = this;
        String[] urls = initSampleData();
        gridViewAdapter = new GridViewAdapter(this, urls);
        gridView.setAdapter(gridViewAdapter);
    }

    private void infixView() {

        gridView = (GridView) findViewById(R.id.grid_view);
    }

    private String[] initSampleData() {
        return new String[]{
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWdDREZGd2cjNmTU0&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWdDREZGd2cjNmTdfgdfgdfgfdgU0&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWZ0tEWmZGdGttQTg&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWaU9GMXMtSF94T2c&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWUFlTZmczOENLa3M&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWdDREZGd2cjNmTdfgdfgdfgfdgU0&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWbElLbXZQbjdETGc&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWN1V1TTR0Qk04dXc&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWdDREZGd2cjNmTdfgdfgdfgfdgU0&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWdDREZGd2cjNmTdfgdfgdfgfdgU0&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWUGRkTDBWazRyS0E&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWZUxQYnZaVTNQZkU&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWa09feFVwZlJOMms&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWNnRFYmpPaXFBQ1k&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWeHNtV3FWSVlWdlU&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWWEhQZF9vbUJzUE0&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWSUh2dnVmc2FyNzQ&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWVERaNjRNQTlyUmM&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWd29OY0hOUnpadGc&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWdDREZGd2cjNmTdfgdfgdfgfdgU0&export=download",
                "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWdDREZGd2cjNmTdfgdfgdfgfdgU0&export=download",

        };
    }
}
