package com.example.krasimir.recipeturnik;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.krasimir.recipeturnik.model.Users;

import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText emailEditText;
    EditText passEditText;
    Button createAccBtn;
    TextView loginLink;
    public final Context ctx=this;
    LoginManager loginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameEditText=(EditText)findViewById(R.id.nameRegEditText);
        emailEditText=(EditText)findViewById(R.id.emailRegEditText);
        passEditText=(EditText)findViewById(R.id.passReqgEditView);
        createAccBtn=(Button) findViewById(R.id.createAccBtn);
        loginLink=(TextView) findViewById(R.id.loginLing);

        loginManager=new LoginManager(ctx);

        createAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(nameEditText)|| isEmpty(emailEditText) || isEmpty(passEditText)){
                    Toast.makeText(RegistrationActivity.this, "Empty fields", Toast.LENGTH_SHORT).show();
                }else {
                    Users newUser=new Users(nameEditText.getText().toString(),emailEditText.getText().toString(),passEditText.getText().toString());
                    newUser.save();
                    loginManager.loginUser(emailEditText.getText().toString(),passEditText.getText().toString());
                    Toast.makeText(RegistrationActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(RegistrationActivity.this,MyProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }



    private boolean isEmpty(EditText myeditText) {
        return myeditText.getText().toString().trim().length() == 0;
    }
}
