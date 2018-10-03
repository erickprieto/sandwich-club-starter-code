package com.udacity.sandwichclub.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit Test for {@link Sandwich}.
 * @author Erick Prieto
 * @since 2018
 */
public class SandwichTest {

    private Sandwich expectedSandwich;
    private Sandwich similarSandwich;
    private Sandwich otherSandwich;
    private Sandwich nullSandwich;

    @Before
    public void setUp() throws Exception {

        expectedSandwich = new Sandwich();
        expectedSandwich.setMainName("Ham and cheese sandwich");
        expectedSandwich.setAlsoKnownAs(Arrays.asList(new String[]{"Sandwich"}));
        expectedSandwich.setDescription("A ham and cheese sandwich is a common type of sandwich.");
        expectedSandwich.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG");
        expectedSandwich.setPlaceOfOrigin("USA");
        expectedSandwich.setIngredients(Arrays.asList(new String[]{"Sliced bread", "Cheese", "Ham"}));

        similarSandwich = new Sandwich();
        similarSandwich.setMainName("Ham and cheese sandwich");
        similarSandwich.setAlsoKnownAs(Arrays.asList(new String[]{"Other Sandwich"}));
        similarSandwich.setDescription("A ham and cheese sandwich is a common type of sandwich.");
        similarSandwich.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG");
        similarSandwich.setPlaceOfOrigin("Mexico");
        similarSandwich.setIngredients(Arrays.asList(new String[]{"Sliced bread", "Cheese", "Ham"}));

        otherSandwich = new Sandwich();
        otherSandwich.setMainName("Bosna");
        otherSandwich.setAlsoKnownAs(Arrays.asList(new String[]{"Bosner"}));
        otherSandwich.setDescription("Bosna is a spicy Austrian fast food dish.");
        otherSandwich.setImage("https://upload.wikimedia.org/wikipedia/commons/c/ca/Bosna_mit_2_Bratw%C3%BCrsten.jpg");
        otherSandwich.setPlaceOfOrigin("Austria");
        otherSandwich.setIngredients(Arrays.asList(new String[]{"White bread", "Bratwurst", "Onions", "Tomato ketchup", "Mustard", "Curry powder"}));

        nullSandwich = new Sandwich();
        otherSandwich.setMainName("");
        otherSandwich.setAlsoKnownAs(Arrays.asList(new String[]{""}));
        otherSandwich.setDescription("");
        otherSandwich.setImage("");
        otherSandwich.setPlaceOfOrigin("");
        otherSandwich.setIngredients(Arrays.asList(new String[]{""}));

    }

    @Test
    public void equalsValidator_ShouldReturnTrue() {
        assertTrue("equalsValidator_ShouldReturnTrue the same", expectedSandwich.equals(expectedSandwich));
    }

    @Test
    public void equalsValidator_ShouldReturnFalse() {
        assertFalse("equalsValidator_ShouldReturnFalse Similar", expectedSandwich.equals(similarSandwich));
    }

    @Test
    public void equalsNullValidator_ShouldReturnFalse() {
        assertFalse("equalsNullValidator_ShouldReturnFalse empty Sandwich", expectedSandwich.equals(nullSandwich));
        assertFalse("equalsNullValidator_ShouldReturnFalse null", expectedSandwich.equals(null));
    }
}
