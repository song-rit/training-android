package th.ac.sut.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import th.ac.sut.listview.adapter.ListViewCustomAdapter;

public class ListViewCustomExample extends AppCompatActivity {

    private ListView listView;
    private ListViewCustomAdapter ladapter;

    private List<String> family = new ArrayList<>();

    public ListViewCustomExample() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_custom_example);

        infixView();

        createFamilyData();

        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.custom_listview, family);

        ladapter = new ListViewCustomAdapter(ListViewCustomExample.this, family);
        listView.setAdapter(ladapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) parent.getItemAtPosition(position);
                Toast.makeText(ListViewCustomExample.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createFamilyData() {
        family.add("Jame");
        family.add("Jib");
        family.add("Jo");
    }

    private void infixView() {
        listView = (ListView) findViewById(R.id.listView_custom);
    }

}
