package th.ac.sut.toolbar;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        infixView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_result_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(R.string.app_result_tittle);
        getSupportActionBar().setSubtitle(R.string.app_result_sub_title);
        getSupportActionBar().setIcon(R.drawable.ic_star);

        String query = new String();

        Intent searchIntent = getIntent();
        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {

            query = searchIntent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(SearchResultsActivity.this, query, Toast.LENGTH_SHORT).show();
        }

        String[] countries = getResources().getStringArray(R.array.countries);
        ArrayList<String> searchResults = new ArrayList<String>();
        for(int i = 0; i < countries.length; i++) {
            if(countries[i].toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(countries[i]);
            }
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, searchResults);
        listView.setAdapter(adapter);
    }

    private void infixView() {
        listView = (ListView) findViewById(R.id.list_view_result_search);
    }
}
