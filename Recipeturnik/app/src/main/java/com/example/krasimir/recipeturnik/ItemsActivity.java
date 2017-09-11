package com.example.krasimir.recipeturnik;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.krasimir.recipeturnik.model.Category;
import com.example.krasimir.recipeturnik.model.CategoryItems;
import com.example.krasimir.recipeturnik.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class ItemsActivity extends AppCompatActivity implements  IOnItemClicked{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<CategoryItems>selectedCategory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedCategory=getIntent().getParcelableArrayListExtra("category_items");

        setTitle(getIntent().getStringExtra("category_name"));

        mRecyclerView=(RecyclerView)findViewById(R.id.manuRecycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        mAdapter = new SelectedCategoryAdapter(selectedCategory,this,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent=new Intent(ItemsActivity.this,RecipeActivity.class);
        CategoryItems currentItem=selectedCategory.get(position);
        List<Recipe> recipe=currentItem.getRecipe();

        intent.putExtra("item_name",currentItem.getItemTitle());
        intent.putExtra("image_url",currentItem.getImageURL());
        intent.putParcelableArrayListExtra("recipe", (ArrayList<? extends Parcelable>) recipe);
        startActivity(intent);
    }
}
