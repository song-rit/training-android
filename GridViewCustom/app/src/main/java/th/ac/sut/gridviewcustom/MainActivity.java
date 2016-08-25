package th.ac.sut.gridviewcustom;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import th.ac.sut.gridviewcustom.adapter.GridViewCustomAdapter;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    LinearLayout gridItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();
        gridView.setAdapter(new GridViewCustomAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final LinearLayout layout = (LinearLayout) view;
                layout.setBackgroundColor(Color.rgb(255, 0, 0));
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        layout.setBackgroundColor(Color.rgb(255, 255, 255));
                    }
                };

                Drawable mDrawable = MainActivity.this.getResources().getDrawable(R.drawable.smile);
                mDrawable.setColorFilter(new
                        PorterDuffColorFilter(0xffffff, PorterDuff.Mode.LIGHTEN));



                handler.postDelayed(runnable, 100);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });

    }

    private void infixView() {

        gridView = (GridView) findViewById(R.id.grid_view);
        gridItem = (LinearLayout) findViewById(R.id.grid_item);

    }
}
