package th.ac.sut.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerBasicExample extends AppCompatActivity {

    private Spinner spinnerYear;
    private Spinner spinnerTerm;

    private List<Integer> year = new ArrayList<>();
    private List<Integer> term = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_basic_example);

        infixView();

        createYearData();
        createTermData();


        ArrayAdapter<Integer> adapterYear = new ArrayAdapter<Integer>(SpinnerBasicExample.this, R.layout.support_simple_spinner_dropdown_item, year);
        spinnerYear.setAdapter(adapterYear);
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), String.valueOf(year.get(position)), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<Integer> adapterTerm = new ArrayAdapter<Integer>(SpinnerBasicExample.this, R.layout.support_simple_spinner_dropdown_item, term);
        spinnerTerm.setAdapter(adapterTerm);
        spinnerTerm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(term.get(position)), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void createTermData() {

        term.add(3);
        term.add(2);
        term.add(1);
    }

    private void createYearData() {

        year.add(2559);
        year.add(2558);
        year.add(2557);
        year.add(2556);
        year.add(2555);
    }


    private void infixView() {
        spinnerTerm = (Spinner) findViewById(R.id.spinner_term);
        spinnerYear = (Spinner) findViewById(R.id.spinner_year);
    }
}
