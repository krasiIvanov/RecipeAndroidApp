package com.example.krasimir.recipeturnik.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

import java.util.List;


public class Category extends SugarRecord implements Parcelable {

    private String categoryName;
    private String descCategoryName;
    private int image;

    public Category(){

    }

    public Category(String categoryName, String descCategoryName, int image) {
        this.setCategoryName(categoryName);
        this.setDescCategoryName(descCategoryName);
        this.setImage(image);
    }

    public List<CategoryItems> getAllItemsInCategory(){
        return CategoryItems.find(CategoryItems.class,"category = ?",String.valueOf(getId()));
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescCategoryName() {
        return descCategoryName;
    }

    public void setDescCategoryName(String descCategoryName) {
        this.descCategoryName = descCategoryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    protected Category(Parcel in) {
        categoryName = in.readString();
        descCategoryName = in.readString();
        image = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryName);
        dest.writeString(descCategoryName);
        dest.writeInt(image);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
