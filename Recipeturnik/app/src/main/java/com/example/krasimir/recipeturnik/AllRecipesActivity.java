package com.example.krasimir.recipeturnik;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.krasimir.recipeturnik.model.Category;
import com.example.krasimir.recipeturnik.model.CategoryItems;
import com.example.krasimir.recipeturnik.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class AllRecipesActivity extends AppCompatActivity implements IOnItemClicked {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<CategoryItems> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.all_recipes));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView=(RecyclerView)findViewById(R.id.manuRecycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset= CategoryItems.listAll(CategoryItems.class);

        mAdapter = new SelectedCategoryAdapter(myDataset,this,this);

        mRecyclerView.setAdapter(mAdapter);



    }

    @Override
    public void onItemClicked(int position) {
        Intent intent=new Intent(AllRecipesActivity.this,RecipeActivity.class);
        CategoryItems currentItem=myDataset.get(position);
        List<Recipe> recipe=currentItem.getRecipe();

        intent.putExtra("item_name",currentItem.getItemTitle());
        intent.putExtra("image_url",currentItem.getImageURL());
        intent.putParcelableArrayListExtra("recipe", (ArrayList<? extends Parcelable>) recipe);
        startActivity(intent);
    }
}
