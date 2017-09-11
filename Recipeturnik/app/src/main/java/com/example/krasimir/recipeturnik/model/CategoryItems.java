package com.example.krasimir.recipeturnik.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Krasimir on 25.2.2017 г..
 */

public class CategoryItems extends SugarRecord implements Parcelable {

    private Category category;
    private String itemTitle;
    private String itemDesc;
    private String imageURL;

    public CategoryItems(){

    }

    public CategoryItems(Category category, String itemTitle, String itemDesc, String imageURL) {

        this.category=category;
        this.setItemTitle(itemTitle);
        this.setItemDesc(itemDesc);
        this.setImageURL(imageURL);
    }

    public List<Recipe> getRecipe(){
       //return Recipe.findById(Recipe.class,id);
        return Recipe.findWithQuery(Recipe.class,"Select * from Recipe where name=?",itemTitle);
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemCategoryIdent() {
        if (category==null){
            return "Unknown";
        }
        return category.getCategoryName();
    }



    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }



    protected CategoryItems(Parcel in) {
        category = (Category) in.readValue(Category.class.getClassLoader());
        itemTitle = in.readString();
        itemDesc = in.readString();
        imageURL = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(category);
        dest.writeString(itemTitle);
        dest.writeString(itemDesc);
        dest.writeString(imageURL);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CategoryItems> CREATOR = new Parcelable.Creator<CategoryItems>() {
        @Override
        public CategoryItems createFromParcel(Parcel in) {
            return new CategoryItems(in);
        }

        @Override
        public CategoryItems[] newArray(int size) {
            return new CategoryItems[size];
        }
    };
}
