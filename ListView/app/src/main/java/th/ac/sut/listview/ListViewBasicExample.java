package th.ac.sut.listview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ListViewBasicExample extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_custom_example);

        infixView();

        final String[] family = {"Jame", "Jib", "Jo"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, family){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view;
                textView.setTextColor(Color.RED);
                return view;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String name =  textView.getText().toString();
                String name2 = (String) parent.getItemAtPosition(position);

                textView.setTextColor(RandomColor());
                Log.d("View", textView.getText().toString());
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void infixView() {
        listView = (ListView) findViewById(R.id.listView_custom);
    }

    private int RandomColor() {

        HashMap<String, Integer> color = new HashMap();
        color.put("BLACK", 0xFF000000);
        color.put("DKGRAY", 0xFF444444);
        color.put("GRAY", 0xFF888888);
        color.put("LTGRAY", 0xFFCCCCCC);
        color.put("WHITE", 0xFFFFFFFF);
        color.put("RED", 0xFFFF0000);
        color.put("GREEN", 0xFF00FF00);
        color.put("BLUE", 0xFF0000FF);
        color.put("YELLOW", 0xFFFFFF00);
        color.put("CYAN", 0xFF00FFFF);
        color.put("MAGENTA", 0xFFFF00FF);

        Log.d("Color Key",String.valueOf( (int)Math.round(Math.random() * 1234 % 11)));
        return color.get(color.keySet().toArray()[(int)Math.round(Math.random() * 10 % 11)]);
    }
}
