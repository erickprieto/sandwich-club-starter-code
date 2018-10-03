package com.udacity.sandwichclub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import org.json.JSONException;

/**
 * Details for selection of MainActivity.
 * @author Erick Prieto
 * @since 2018
 */
public class DetailActivity extends AppCompatActivity {

    /**
     * Name of reference to log all records of events in this class.
     */
    private static final String TAG = DetailActivity.class.getSimpleName();

    /**
     * Intent extra identifier of position.
     */
    public static final String EXTRA_POSITION = "extra_position";

    /**
     * Default value of position of list to show on this Activity.
     */
    private static final int DEFAULT_POSITION = -1;

    /**
     * Model of Sandwich to show on this Activity.
     */
    private Sandwich sandwich;

    /**
     * Position inside of the list of Sandwiches.
     */
    private int listPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getExtraFromIntent();

        this.sandwich = getSandwich(this.listPosition);
        setTitle(this.sandwich.getMainName());

        populateUI();

    }

    /**
     * Receive Extra Intent information from {@link MainActivity}.
     */
    private void getExtraFromIntent() {

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError("Intent from MainActivity Empty.");
        }

        this.listPosition = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (this.listPosition == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError("EXTRA_POSITION not found in intent");
        }
    }

    /**
     * Find PictureSandwichImageView on layout.(not member variable)
     * @return View
     */
    private ImageView getPictureSandwichImageView() {
        return (ImageView) findViewById(R.id.DetailActivity_pictureImageView);
    }

    /**
     * Find IngredientsTextView on layout. (not member variable)
     * @return View
     */
    private TextView getIngredientsTextView(){
        return (TextView) findViewById(R.id.DetailActivity_ingredientsTextView);
    }

    /**
     * Find AlsoKnowTextView on layout. (not member variable)
     * @return View
     */
    private TextView getAlsoKnowTextView(){
        return (TextView) findViewById(R.id.DetailActivity_alsoKnownTextView);
    }

    /**
     * Find DescriptionTextView on layout. (not member variable)
     * @return View
     */
    private TextView getDescriptionTextView(){
        return (TextView) findViewById(R.id.DetailActivity_descriptionTextView);
    }

    /**
     * Find PlaceOriginTextView on layout. (not member variable)
     * @return View
     */
    private TextView getPlaceOriginTextView(){
        return (TextView) findViewById(R.id.DetailActivity_placeOriginTextView);
    }



    @Nullable
    private Sandwich getSandwich(int position) {
        try {
            String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
            String json = sandwiches[position];
            Sandwich sandwich = JsonUtils.parseSandwichJson(json);
            if (sandwich == null) {
                // Sandwich data unavailable
                closeOnError("Sandwich data unavailable");
                return null;
            }
            return sandwich;
        } catch (JSONException jsonEx) {
            // Sandwich data unavailable
            Log.wtf(TAG, jsonEx);
            closeOnError(jsonEx.getMessage());
            return null;
        }
    }

    /**
     * Solicite {@link #Activity#finish()} if a Exception happens.
     * @param exception
     */
    private void closeOnError(String exception) {
        Log.e(TAG, exception);
        finish();
        Toast.makeText(this, R.string.DetailActivity_detailErrorMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * Fill UI with model Sandwich data.
     */
    private void populateUI() {

        this.getAlsoKnowTextView().setText(this.sandwich.getAlsoKnownAs().toString());
        this.getDescriptionTextView().setText(this.sandwich.getDescription());
        this.getIngredientsTextView().setText(this.sandwich.getIngredients().toString());
        this.getPlaceOriginTextView().setText(this.sandwich.getPlaceOfOrigin());

        Picasso.with(this)
                .load(sandwich.getImage())
                .error(android.support.graphics.drawable.R.drawable.notification_bg)
                .into(this.getPictureSandwichImageView());
    }
}
