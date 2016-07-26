package th.ac.sut.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import th.ac.sut.listview.R;
import th.ac.sut.listview.adapter.ListViewCustomImageAdapter;

public class ListViewCustomImage extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_custom_image);

        int[] resourceId = {
                R.drawable.bmw_s1000rr_hp4,
                R.drawable.ducati_monster_696_anniversary,
                R.drawable.harley_davidson_seventy_two,
                R.drawable.honda_nc700x,
                R.drawable.kawasaki_ninja_300,
                R.drawable.moto_guzzi_v7_racer,
                R.drawable.suzuki_sfv_650,
                R.drawable.victory_judge,
                R.drawable.yamaha_super_tenere,
                R.drawable.zero_s
        };

        String[] strList = {
                "bmw_s1000rr_hp4",
                "ducati_monster_696_anniversary",
                "harley_davidson_seventy_two",
                "honda_nc700x",
                "kawasaki_ninja_300",
                "moto_guzzi_v7_racer",
                "suzuki_sfv_650",
                "victory_judge",
                "yamaha_super_tenere",
                "zero_s"
        };

        ListViewCustomImageAdapter adapter = new ListViewCustomImageAdapter(getApplicationContext(), strList, resourceId);

        listView = (ListView) findViewById(R.id.listView_custom);
        listView.setAdapter(adapter);
    }
}
