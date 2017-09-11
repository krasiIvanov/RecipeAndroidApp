package com.example.krasimir.recipeturnik;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krasimir.recipeturnik.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {
    ImageView image;
    TextView time;
    TextView servings;
    TextView ingradients;
    TextView directions;
    List<Recipe> recipeList;
    Recipe recipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        time=(TextView)findViewById(R.id.timeRecipeTextView);
        servings=(TextView)findViewById(R.id.servingsRecipeTextView);
        ingradients=(TextView)findViewById(R.id.ingradientsTextView);
        directions=(TextView)findViewById(R.id.directionsTextView);


        toolbar.setTitle(getIntent().getStringExtra("item_name"));
        setSupportActionBar(toolbar);
        recipeList=getIntent().getParcelableArrayListExtra("recipe");
        recipe=recipeList.get(0);
        time.setText("Prep:"+recipe.getTime()+" min.");
        servings.setText("Serves :"+recipe.getServes());
        ingradients.setText(recipe.getIngredients());
        directions.setText(recipe.getDirections());
        image=(ImageView)findViewById(R.id.image_id);
        Picasso.with(this).load(getIntent().getStringExtra("image_url")).into(image);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
