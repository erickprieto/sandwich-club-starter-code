package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit Test for {@link JsonUtils}.
 * @author Erick Prieto
 * @since 2018
 */
public class JsonUtilsTest {

    private String json = "{\"name\":{\"mainName\":\"Ham and cheese sandwich\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"\",\"description\":\"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\"ingredients\":[\"Sliced bread\",\"Cheese\",\"Ham\"]}";
    private Sandwich expectedSandwich;
    private Sandwich parseNull;

    @Before
    public void setUp() throws Exception {

        expectedSandwich = new Sandwich();
        expectedSandwich.setMainName("Ham and cheese sandwich");
        expectedSandwich.setAlsoKnownAs(new ArrayList<String>());
        expectedSandwich.setDescription("A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.");
        expectedSandwich.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG");
        expectedSandwich.setPlaceOfOrigin("");
        String ingredients [] = new String[] {"Sliced bread", "Cheese", "Ham"};
        expectedSandwich.setIngredients(Arrays.asList(ingredients));

        parseNull = new Sandwich();

    }

    @Test
    public void parseSandwichJsonValidator_ShouldReturnSandwich() {
        Sandwich parsed = null;
        try {
             parsed = JsonUtils.parseSandwichJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assertTrue( "parseSandwichJsonValidator_ShouldReturnSandwich"
                , expectedSandwich.equals(parsed) );
    }

}
