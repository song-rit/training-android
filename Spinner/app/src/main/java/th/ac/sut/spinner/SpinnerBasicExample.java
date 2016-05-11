package th.ac.sut.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

        ArrayAdapter<Integer> adapterTerm = new ArrayAdapter<Integer>(SpinnerBasicExample.this, R.layout.support_simple_spinner_dropdown_item, term);
        spinnerTerm.setAdapter(adapterTerm);
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
