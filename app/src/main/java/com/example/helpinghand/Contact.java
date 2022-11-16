package com.example.helpinghand;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helpinghand.database.Database;

import java.sql.SQLException;

public class Contact extends AppCompatActivity {

    private TextView contactDetails;
    private Button chat;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.contact);
        contactDetails = findViewById(R.id.textViewContact);
        Database user = new Database();


        String username = getIntent().getStringExtra("title");
        try {
            String firstName = user.readFirstname(username);
            String postcode = user.readPostcode(username);
            String kindOfHelp = user.readKindOfHelp(username);
            String aboutMe = user.readAboutMe(username);
            contactDetails.setText(" Username: "+username+"\n First Name: "+firstName +"\n Postcode: "+postcode+"\n Needs: "+ kindOfHelp+
                    "\n About: "+aboutMe);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        chat = findViewById(R.id.buttonStartChat);

        chat.setOnClickListener(v ->{
            Intent chatting = new Intent(Contact.this, Chat.class);
            startActivity(chatting);
        });


    }


}
