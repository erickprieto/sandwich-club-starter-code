package com.udacity.sandwichclub.utils;

import android.util.Log;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

/**
 * Utilities to serialize and deserealize JSON file format.
 * This class only provide utilitary methods.
 * @author Erick Prieto
 * @since 2018
 */
public class JsonUtils {

    /**
     * Name of reference to log all records of events in this class.
     */
    private static final String TAG = JsonUtils.class.getSimpleName();

    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE = "image";
    private static final String INGREDIENTS = "ingredients";

    /**
     * Only provide utilitary methods. Not public constructor needed.
     */
    private JsonUtils(){}

    /**
     * Deserialize from {@link String} to {@link Sandwich}.
     * Order of JSON file properties :
     *            { "name": {
     *                      "mainName":
     *                      "alsoKnownAs" []:
     *             }
     *             "placeOfOrigin":
     *             "description":
     *             "image":
     *             "ingredients" []:
     *             }
     * @param json String with a {@link Sandwich} serialized.
     * @return {@link Sandwich} deserialized data.
     * @throws {@link JSONException} if an exception happens on JSON deserialize.
     * @throws {@link IllegalArgumentException} if {@see String} json is null.
     */
    public static Sandwich parseSandwichJson(String json) throws JSONException {
        try {
            if(json == null || json == "") { throw new IllegalArgumentException("String Json Null Argument"); }

            JSONObject jsonObject = new JSONObject(json);
            return parseSandwichJSONObject(jsonObject);

        } catch(IllegalArgumentException iaEx) {
            Log.e(TAG,"Parameter: " + json + "-" + iaEx.getStackTrace());
            throw iaEx;
        } catch(JSONException jsonEx) {
            Log.e(TAG,"Parameter: " + json + "-" + jsonEx.getStackTrace());
            throw jsonEx;
        } catch(Exception ex) {
            Log.e(TAG,"Parameter: " + json + "-" + ex.getStackTrace());
            throw ex;
        }
    }

    /**
     * Deserialize from {@link JSONObject} to {@link Sandwich}.
     * Objects inside of JSON Object:
     *            { "name": {
     *                      "mainName":
     *                      "alsoKnownAs" []:
     *             }
     *             "placeOfOrigin":
     *             "description":
     *             "image":
     *             "ingredients" []:
     *             }
     * @param jsonObj String with a {@link Sandwich} serialized.
     * @return {@link Sandwich} deserialized data.
     * @throws {@link JSONException} if an exception happens on JSON objects arregnment.
     */
    private static Sandwich parseSandwichJSONObject(JSONObject jsonObj) throws JSONException, IllegalArgumentException {
        if(jsonObj == null) { throw new IllegalArgumentException("Null Argument on JSONObject"); }

        Sandwich sandwich = new Sandwich();
        sandwich.setAlsoKnownAs(new ArrayList<String>());
        sandwich.setIngredients(new ArrayList<String>());

        JSONObject name = jsonObj.getJSONObject(NAME);

        sandwich.setMainName(name.getString(MAIN_NAME));

        JSONArray alias = name.getJSONArray(ALSO_KNOWN_AS);
        for(int i = 0; i < alias.length(); i++) {
            sandwich.getAlsoKnownAs().add(alias.getString(i));
        }

        sandwich.setPlaceOfOrigin( jsonObj.getString(PLACE_OF_ORIGIN));
        sandwich.setDescription( jsonObj.getString(DESCRIPTION));
        sandwich.setImage( jsonObj.getString(IMAGE));

        JSONArray ingredients = jsonObj.getJSONArray(INGREDIENTS);
        for(int i = 0; i < ingredients.length(); i++) {
            sandwich.getIngredients().add(ingredients.getString(i));
        }
        return sandwich;
    }
}
