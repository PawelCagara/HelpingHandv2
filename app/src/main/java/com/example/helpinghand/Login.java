package com.example.helpinghand;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helpinghand.database.Database;
import com.example.helpinghand.helpers.UserLoginCache;
import com.example.helpinghand.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.SQLException;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login = findViewById(R.id.loginUserButton);
        username =  findViewById(R.id.loginUsername);
        password =  findViewById(R.id.loginPassword);

        login.setOnClickListener(v -> {
            String loginUsername = username.getText().toString();
            String loginPassword = password.getText().toString();
            Database user = new Database();

            if (loginUsername.isEmpty() || loginPassword.isEmpty()){
                Toast.makeText(Login.this, "All fields are required",
                        Toast.LENGTH_SHORT).show();
            } else{
                try {
                    int c = user.checkUsernameAndPassword(loginUsername,loginPassword);
                    if(c>0){
                        Intent loginSuccessful = new Intent(Login.this, HomePage.class);
                        UserLoginCache.login(loginUsername);
                        startActivity(loginSuccessful);
                    } else{
                        Toast.makeText(getApplicationContext(), "LOGIN DETAILS ARE INCORRECT", Toast.LENGTH_LONG).show();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }


}
