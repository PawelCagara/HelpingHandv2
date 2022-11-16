package com.example.helpinghand;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helpinghand.database.Database;
import com.example.helpinghand.model.User;

import java.sql.SQLException;

public class Register extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button register = findViewById(R.id.registerUserButton);
        username = findViewById(R.id.registerUsername);
        password = findViewById(R.id.registerPassword);
        email = findViewById(R.id.registerEmail);

        register.setOnClickListener(v -> {

            String user_name = username.getText().toString().trim();
            String txt_password = password.getText().toString().trim();
            String email_address = email.getText().toString().trim();
            String firstname = "";
            String postcode = "";
            int group = 0;
            int admin =0;
            String kindOfHelp = "";
            String aboutMe = "";

            Database user = new Database();

            if(TextUtils.isEmpty(user_name) || TextUtils.isEmpty(email_address) || TextUtils.isEmpty(txt_password)) {
                Toast.makeText(Register.this, "All fields are required",
                        Toast.LENGTH_SHORT).show();
            } else {

                if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                    Toast.makeText(Register.this, "Email invalid",
                            Toast.LENGTH_SHORT).show();
                } else{
                    try {
                        int c = user.checkIfUserExist(user_name);
                        if(c>0){
                            Toast.makeText(getApplicationContext(), "USER ALREADY EXITS", Toast.LENGTH_LONG).show();
                        } else{
                            if(txt_password.length()<6 || txt_password.length()>100){
                                Toast.makeText(getApplicationContext(), "Password must be 6-100 characters long", Toast.LENGTH_LONG).show();
                            } else{
                                user.addUser(user_name,email_address,txt_password,firstname,postcode,group,admin,kindOfHelp, aboutMe);
                                Intent registrationSuccessful = new Intent(Register.this, RegisterSuccessful.class);
                                startActivity(registrationSuccessful);
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }
            }
        });

    }


}
