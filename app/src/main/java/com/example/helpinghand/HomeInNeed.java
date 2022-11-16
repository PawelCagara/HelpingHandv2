package com.example.helpinghand;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.helpinghand.database.Database;
import com.example.helpinghand.helpers.UserLoginCache;
import com.google.android.material.navigation.NavigationView;

import java.sql.SQLException;

public class HomeInNeed extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBar;
    private EditText kindOfHelp;
    private EditText aboutMe;
    private Button chat;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_in_need);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBar = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        actionBar.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBar);
        actionBar.syncState();

        Button submit = findViewById(R.id.buttonInNeedSubmit);
        kindOfHelp = findViewById(R.id.editTextKindOfHelp);
        aboutMe = findViewById(R.id.editTextAboutYourself);
        Database db = new Database();
        String user = UserLoginCache.getLoggedUser();

        Button uploadPhoto = findViewById(R.id.buttonReceiveChat);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = (NavigationView) findViewById(R.id.navbar);

        navView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if(itemId == R.id.navUpdateProfile){
                Intent update = new Intent(HomeInNeed.this, ProfileUpdate.class);
                startActivity(update);
            } else if(itemId == R.id.navChangePassword){
                Intent update = new Intent(HomeInNeed.this, PasswordChange.class);
                startActivity(update);
            } else if (itemId == R.id.navChangeGroup){
                Intent update = new Intent(HomeInNeed.this, ChangeGroup.class);
                startActivity(update);
            } else if(itemId == R.id.navLogout){
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeInNeed.this);
                builder.setTitle("Logout confirmation").
                        setMessage("Are you sure you want to logout?");
                builder.setPositiveButton("Yes",
                        (dialog, id) -> {
                            Intent i = new Intent(getApplicationContext(),
                                    MainActivity.class);
                            startActivity(i);
                        });
                builder.setNegativeButton("No",
                        (dialog, id) -> dialog.cancel());
                AlertDialog alert11 = builder.create();
                alert11.show();

            }
            return true;
        });



        submit.setOnClickListener(view->{
            String submitKindOfHelp = kindOfHelp.getText().toString();
            String submitAboutMe = aboutMe.getText().toString();
            try {
                db.updateInNeedInfo(user,submitKindOfHelp,submitAboutMe);
                Toast.makeText(getApplicationContext(), "Details saved", Toast.LENGTH_LONG).show();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        chat = findViewById(R.id.buttonReceiveChat);

        chat.setOnClickListener(v ->{
            Intent chatting = new Intent(HomeInNeed.this, Chat.class);
            startActivity(chatting);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return actionBar.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
