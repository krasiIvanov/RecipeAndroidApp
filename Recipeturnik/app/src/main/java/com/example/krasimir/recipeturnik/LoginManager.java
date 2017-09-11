package com.example.krasimir.recipeturnik;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Krasimir on 17.3.2017 г..
 */

public class LoginManager {
    //save data to local storege
    SharedPreferences preferences;
    //comit each action to editor;
    SharedPreferences.Editor preferencesEditor;

    Context context;

    int PRIVATE_MODE=0;

    private static final String PREFS_NAME="PrefLogin";

    //is_loged KEY
    private static final String LOGIN_KEY="login";

    //username
    private static final String USERNAME_KEY="username";
    //password
    private static final String PASSWORD="pass";

    public LoginManager(Context ctx){

        this.context=ctx;
        this.preferences=context.getSharedPreferences(PREFS_NAME,PRIVATE_MODE);
        this.preferencesEditor=preferences.edit();

    }
    private boolean applyPrefChanges(String username,String password, boolean isLogin){

        if (preferences!=null && preferencesEditor!=null){

            preferencesEditor.putString(USERNAME_KEY,username);
            preferencesEditor.putString(PASSWORD,password);
            preferencesEditor.putBoolean(LOGIN_KEY,isLogin);


            return  preferencesEditor.commit();
        }

        return  false;
    }
    //return true if login
    public boolean loginUser(String username,String password){
        return  applyPrefChanges(username,password,true);
    }
    public boolean signOutUser(){
        if (isLoggedIn()){

            return applyPrefChanges("","",false);
        }

        return  false;

    }

    public boolean isLoggedIn(){
        if (preferences==null){
            return false;
        }else {
            return  preferences.getBoolean(LOGIN_KEY,false);
        }
    }

}
