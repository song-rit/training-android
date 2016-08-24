package th.ac.sut.gridviewcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import th.ac.sut.gridviewcustom.adapter.GridViewCustomAdapter;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infixView();
        gridView.setAdapter(new GridViewCustomAdapter(this));

    }

    private void infixView() {

        gridView = (GridView) findViewById(R.id.grid_view);

    }
}
