package com.example.krasimir.recipeturnik;

import android.content.Context;
import android.content.Intent;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    public final Context ctx=this;
    Button categoryBtn;
    Button searchBtn;
    Button profileBtn;
    Button allRecipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        categoryBtn=(Button)findViewById(R.id.categoryButton);
        searchBtn=(Button)findViewById(R.id.searchButton);
        profileBtn=(Button)findViewById(R.id.profileButton);
        allRecipes=(Button)findViewById(R.id.allRecipesButton);

        categoryBtn.setOnClickListener(onClick);
        profileBtn.setOnClickListener(onClick);
        searchBtn.setOnClickListener(onClick);
        allRecipes.setOnClickListener(onClick);

    }
    View.OnClickListener onClick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent;
            switch (view.getId()){
                case R.id.categoryButton:
                    intent=new Intent(MenuActivity.this,MainActivity.class);
                    break;


                case R.id.profileButton:
                    LoginManager loginManager=new LoginManager(ctx);
                    if (loginManager.isLoggedIn()){
                        intent=new Intent(MenuActivity.this,MyProfileActivity.class);
                    }else{
                        intent=new Intent(MenuActivity.this,LoginActivity.class);
                    }

                    break;

                case R.id.searchButton:
                    intent=new Intent(MenuActivity.this,SearchActivity.class);
                    break;
                case R.id.allRecipesButton:
                    intent=new Intent(MenuActivity.this,AllRecipesActivity.class);
                    break;
                default:intent=new Intent();
        }

            startActivity(intent);
        }
    };
}
