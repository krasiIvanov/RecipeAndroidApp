package com.example.krasimir.recipeturnik.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;



public class Recipe extends SugarRecord  implements Parcelable {

    private CategoryItems item;
    private String name;
    private String ingredients;
    private String time;
    private String serves;
    private String directions;


    public Recipe(){

    }

    public Recipe(CategoryItems item, String ingredients, String time, String serves, String directions) {
        this.item=item;
        this.setName(name);
        this.setIngredients(ingredients);
        this.setTime(time);
        this.setServes(serves);
        this.setDirections(directions);
    }

    public CategoryItems getItem() {
        return item;
    }

    public void setItem(CategoryItems item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = item.getItemTitle();
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServes() {
        return serves;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }



    protected Recipe(Parcel in) {
        item = (CategoryItems) in.readValue(CategoryItems.class.getClassLoader());
        name = in.readString();
        ingredients = in.readString();
        time = in.readString();
        serves = in.readString();
        directions = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(item);
        dest.writeString(name);
        dest.writeString(ingredients);
        dest.writeString(time);
        dest.writeString(serves);
        dest.writeString(directions);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}