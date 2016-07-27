package th.ac.sut.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import th.ac.sut.listview.adapter.ListViewCustomImageAdapter;
import th.ac.sut.listview.model.Image;

public class ListViewCustomImage extends AppCompatActivity {

    ListView listView;
    private ArrayList<Image> images = new ArrayList<>();
    Gson gson = new GsonBuilder().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_custom_image);

        int[] resourceId = {
                R.drawable.bmw_s1000rr_hp4,
                R.drawable.ducati_monster_696_anniversary,
                R.drawable.ferrari_laferrari,
                R.drawable.gumpert_apollo,
                R.drawable.harley_davidson_seventy_two,
                R.drawable.honda_nc700x,
                R.drawable.kawasaki_ninja_300,
                R.drawable.koenigsegg_ccx,
                R.drawable.lamborghini_huracan,
                R.drawable.lamborghini_veneno,
                R.drawable.mclaren_650s,
                R.drawable.mclaren_f1,
                R.drawable.mclaren_p1,
                R.drawable.moto_guzzi_v7_racer,
                R.drawable.noble_m600,
                R.drawable.pagani_huayra,
                R.drawable.porsche_918_spyder,
                R.drawable.saleen_s7_tt,
                R.drawable.suzuki_sfv_650,
                R.drawable.victory_judge,
                R.drawable.yamaha_super_tenere,
                R.drawable.zenvo_st1,
                R.drawable.zero_s,
                R.drawable.zero_s2,
                R.drawable.zero_s3,
                R.drawable.zero_s4,
                R.drawable.zero_s5,
                R.drawable.zero_s6,
                R.drawable.zero_s7,
                R.drawable.zero_s8,
                R.drawable.zero_s9,
                R.drawable.zero_s10,
                R.drawable.zero_s11,
                R.drawable.zero_s12,
                R.drawable.zero_s13,
                R.drawable.zero_s14,
                R.drawable.zero_s15,
                R.drawable.zero_s16,
                R.drawable.zero_s17,
                R.drawable.zero_s18,
                R.drawable.zero_s19,
                R.drawable.zero_s20,
                R.drawable.zenvo_st2,
                R.drawable.zenvo_st3,
                R.drawable.zenvo_st4,
                R.drawable.zenvo_st5,
                R.drawable.zenvo_st6,
                R.drawable.zenvo_st7,
                R.drawable.zenvo_st8,
                R.drawable.zenvo_st9,
                R.drawable.zenvo_st10,
                R.drawable.zenvo_st11,
                R.drawable.zenvo_st12,
                R.drawable.zenvo_st13,
                R.drawable.zenvo_st14,
                R.drawable.zenvo_st15,
                R.drawable.zenvo_st16,
                R.drawable.zenvo_st17,
                R.drawable.zenvo_st18,
                R.drawable.zenvo_st19,
                R.drawable.zenvo_st20
        };

        String[] strList = {
                "bmw_s1000rr_hp4",
                "ducati_monster_696_anniversary",
                "ferrari_laferrari",
                "gumpert_apollo",
                "harley_davidson_seventy_two",
                "honda_nc700x",
                "kawasaki_ninja_300",
                "koenigsegg_ccx",
                "lamborghini_huracan",
                "lamborghini_veneno",
                "mclaren_650s",
                "mclaren_f1",
                "mclaren_p1",
                "moto_guzzi_v7_racer",
                "noble_m600",
                "pagani_huayra",
                "porsche_918_spyder",
                "saleen_s7_tt",
                "suzuki_sfv_650",
                "victory_judge",
                "yamaha_super_tenere",
                "zenvo_st1",
                "zero_s",
                "zero_s2",
                "zero_s3",
                "zero_s4",
                "zero_s5",
                "zero_s6",
                "zero_s7",
                "zero_s8",
                "zero_s9",
                "zero_s10",
                "zero_s11",
                "zero_s12",
                "zero_s13",
                "zero_s14",
                "zero_s15",
                "zero_s16",
                "zero_s17",
                "zero_s18",
                "zero_s19",
                "zero_s20",
                "zenvo_st2",
                "zenvo_st3",
                "zenvo_st4",
                "zenvo_st5",
                "zenvo_st6",
                "zenvo_st7",
                "zenvo_st8",
                "zenvo_st9",
                "zenvo_st10",
                "zenvo_st11",
                "zenvo_st12",
                "zenvo_st13",
                "zenvo_st14",
                "zenvo_st15",
                "zenvo_st16",
                "zenvo_st17",
                "zenvo_st18",
                "zenvo_st19",
                "zenvo_st20"
        };

        for(int i = 0; i < resourceId.length; i++) {
            Image image = new Image();
            image.setName(strList[i]);
            image.setResourceId(resourceId[i]);
            images.add(image);
        }

        ListViewCustomImageAdapter adapter = new ListViewCustomImageAdapter(getApplicationContext(), images);

        listView = (ListView) findViewById(R.id.list_view_custom_image);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListViewCustomImage.this, ImageShow.class);
                String JSONData = gson.toJson(images.get(position));
                intent.putExtra("JSON", JSONData);
                startActivity(intent);
            }
        });
    }
}
