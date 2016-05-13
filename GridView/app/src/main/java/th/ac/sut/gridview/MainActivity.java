package th.ac.sut.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import th.ac.sut.gridview.adapter.GridViewCustomAdapter;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();

        gridView.setAdapter(new GridViewCustomAdapter(MainActivity.this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "" + String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void infixView() {
        gridView = (GridView) findViewById(R.id.grid_view);
    }
}
