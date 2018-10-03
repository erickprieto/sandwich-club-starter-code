package com.udacity.sandwichclub.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Sandwich model hold transactions between provider and consumer.
 * @author Erick Prieto
 * @since 2018
 */
public class Sandwich implements Parcelable {

    /**
     * Name Id.
     */
    private String mainName;

    /**
     * Collection of alternate names.
     */
    private List<String> alsoKnownAs = null;

    /**
     * Country of Origin.
     */
    private String placeOfOrigin;

    /**
     * Description of Sandwich.
     */
    private String description;

    /**
     * Http adress to access at image.
     */
    private String image;

    /**
     * Collection of ingredients.
     */
    private List<String> ingredients = null;

    /**
     * Constructor <code>Parcelable</code> compatible.
     */
    public static final Creator<Sandwich> CREATOR = new Creator<Sandwich>() {
        @Override
        public Sandwich createFromParcel(Parcel in) {
            return new Sandwich(in);
        }

        @Override
        public Sandwich[] newArray(int size) {
            return new Sandwich[size];
        }
    };

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    /**
     * Constructor since of every property of this class.
     * @param mainName String
     * @param alsoKnownAs List
     * @param placeOfOrigin String
     * @param description String
     * @param image String
     * @param ingredients List
     */
    public Sandwich(String mainName
            , List<String> alsoKnownAs
            , String placeOfOrigin
            , String description
            , String image
            , List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    /**
     * Contructor for Parcelable access.
     * @param in Parcel to rebuild a Sandwich instance.
     */
    protected Sandwich(Parcel in) {
        mainName = in.readString();
        alsoKnownAs = in.createStringArrayList();
        placeOfOrigin = in.readString();
        description = in.readString();
        image = in.readString();
        ingredients = in.createStringArrayList();
    }


    /**
     * Get Name Id.
     * @return String not null
     */
    public String getMainName() {
        return mainName;
    }

    /**
     * Set Name Id.
     * @param mainName String
     */
    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    /**
     * Get List of alter Names. Should be Empty List.
     * @return List
     */
    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    /**
     * Set List of Alter Names
     * @param alsoKnownAs List
     */
    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    /**
     * Get Name of Country.
     * @return String
     */
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    /**
     * Set Name of Country
     * @param placeOfOrigin String.
     */
    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    /**
     * Get Description.
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set Description
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get Http URL.
     * @return String
     */
    public String getImage() {
        return image;
    }

    /**
     * Set Http URL.
     * @param image String
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get ingredients.
     * @return List
     */
    public List<String> getIngredients() {
        return ingredients;
    }

    /**
     * Set ingredients.
     * @param ingredients List
     */
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mainName);
        dest.writeStringList(alsoKnownAs);
        dest.writeString(placeOfOrigin);
        dest.writeString(description);
        dest.writeString(image);
        dest.writeStringList(ingredients);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Sandwich other = (Sandwich) obj;
        if (!mainName.equals(other.mainName)) { return false; }
        if (!description.equals(other.description)) { return false; }
        if (!image.equals(other.image)) { return false;}
        if (!placeOfOrigin.equals(other.placeOfOrigin)) { return false; }
        if ( !alsoKnownAs.equals(other.alsoKnownAs)) { return false; }
        if ( !ingredients.equals(other.ingredients)) { return false; }
        return true;
    }

    @Override
    public String toString() {
        return "[" + super.toString() + "]"
                + " mainName:" + this.mainName
                + " description:" + this.description
                + " image:" + this.image
                + " placeOfOrigin:" + this. placeOfOrigin
                + " alsoKnownAs:" + this.alsoKnownAs
                + " ingredients:" + this.ingredients;
    }
}
