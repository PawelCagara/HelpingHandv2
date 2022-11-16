package com.example.helpinghand;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class HomeHelpers extends AppCompatActivity {


    private Button map;
    private Button chat;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_helpers);



        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBar = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        actionBar.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBar);
        actionBar.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = (NavigationView) findViewById(R.id.navbar);
        navView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if(itemId == R.id.navUpdateProfile){
                Intent update = new Intent(HomeHelpers.this, ProfileUpdate.class);
                startActivity(update);
            } else if(itemId == R.id.navChangePassword){
                Intent update = new Intent(HomeHelpers.this, PasswordChange.class);
                startActivity(update);
            } else if (itemId == R.id.navChangeGroup){
                Intent update = new Intent(HomeHelpers.this, ChangeGroup.class);
                startActivity(update);
            } else if(itemId == R.id.navLogout){
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeHelpers.this);
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

        map = findViewById(R.id.buttonGoToMap);

        map.setOnClickListener(v ->{
            Intent maps = new Intent(HomeHelpers.this, MapsActivity.class);
            startActivity(maps);
        });

        //chat = findViewById(R.id.buttonStartChat);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return actionBar.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
