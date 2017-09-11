package com.example.krasimir.recipeturnik;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.krasimir.recipeturnik.model.Category;
import com.example.krasimir.recipeturnik.model.CategoryItems;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnItemClicked {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<Category>myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.menu));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView=(RecyclerView)findViewById(R.id.manuRecycleView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset=Category.listAll(Category.class);

        mAdapter = new MenuCategoryAdapter(myDataset,this);

        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onItemClicked(int position) {
        Intent intent=new Intent(MainActivity.this,ItemsActivity.class);

        Category category=myDataset.get(position);
        List<CategoryItems> items=category.getAllItemsInCategory();

        intent.putExtra("category_name",category.getCategoryName());

        intent.putParcelableArrayListExtra("category_items", (ArrayList<? extends Parcelable>) items);

        startActivity(intent);
    }
}
