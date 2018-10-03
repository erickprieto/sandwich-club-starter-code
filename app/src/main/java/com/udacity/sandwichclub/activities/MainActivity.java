package com.udacity.sandwichclub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

/**
 * First Activity on show to User at launch time.
 * List of {@link Sandwich}, showing only names.
 * @author Erick Prieto
 * @since 2018
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Name of reference to log all records of events in this class.
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this
                , android.R.layout.simple_list_item_1
                , sandwiches);

        // Simplification: Using a ListView instead of a RecyclerView
        ListView listView = (ListView) findViewById(R.id.MainActivity_sandwichesListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                launchDetailActivity(position);
            }
        });
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }
}
