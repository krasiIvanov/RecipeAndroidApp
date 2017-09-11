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

import org.w3c.dom.Text;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button login;
    TextView regLink;
    public final Context ctx=this;
    LoginManager loginManager;

    Users user=new Users();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        loginManager=new LoginManager(ctx);

        email=(EditText)findViewById(R.id.emailLoginEditText);
        password=(EditText)findViewById(R.id.passLoginEditText);
        login=(Button)findViewById(R.id.loginButton);
        regLink=(TextView)findViewById(R.id.siqninLink);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Users> userDetails= user.loginUser(email.getText().toString(),password.getText().toString());
                if (userDetails.size()>0){
                    boolean isUserLogin= loginManager.loginUser(email.getText().toString(),password.getText().toString());

                    if (isUserLogin){
                        Toast.makeText(ctx, "LOGIN", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(LoginActivity.this,MyProfileActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }else{
                    Toast.makeText(ctx, "WRONG DETAILS", Toast.LENGTH_SHORT).show();
                }
            }
        });
        regLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }

}
