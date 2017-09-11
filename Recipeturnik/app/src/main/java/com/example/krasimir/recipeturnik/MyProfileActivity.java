package com.example.krasimir.recipeturnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyProfileActivity extends AppCompatActivity {

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final LoginManager loginManager;

        logout=(Button)findViewById(R.id.logoutButton);
        loginManager=new LoginManager(this);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginManager.signOutUser();
                Intent intent=new Intent(MyProfileActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
