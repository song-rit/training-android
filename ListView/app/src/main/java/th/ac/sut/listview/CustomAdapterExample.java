package th.ac.sut.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class CustomAdapterExample extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_example);

        String[] family = new String[]{"Jame", "Jib", "Jo"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.custom_listview, family);


    }
}
