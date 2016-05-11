package th.ac.sut.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import th.ac.sut.spinner.adapter.CustomSpinnerAdapter;

public class SpinnerCustomExample extends AppCompatActivity {

    private Spinner spinner;

    private List<String> family = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_custom_example);

        infixView();

        createFamilyData();

        CustomSpinnerAdapter spinnerAdapter = new CustomSpinnerAdapter(this, (ArrayList<String>) family);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), family.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void createFamilyData() {
        family.add("Jame");
        family.add("Jib");
        family.add("jo");
    }

    private void infixView() {
        spinner = (Spinner) findViewById(R.id.spinner_family);
    }
}
