package com.example.cafelegend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    TextView welcomeTV;
    Bundle extras;

    void setDrawer(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    void init(){
        drawerLayout = findViewById(R.id.drawerLayoutHome);
        navView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);

        welcomeTV = toolbar.findViewById(R.id.welcomeTV);
        extras = getIntent().getExtras();
        welcomeTV.setText("Welcome, " + extras.getString("username"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        setDrawer();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.item1:
                intent = new Intent(this, Item.class);
                intent.putExtra("username", extras.getString("username"));
                startActivity(intent);
                overridePendingTransition(R.anim.from_right, R.anim.to_left);
                return true;
            case R.id.item2:
                intent = new Intent(this, FindUs.class);
                intent.putExtra("username", extras.getString("username"));
                startActivity(intent);
                overridePendingTransition(R.anim.from_right, R.anim.to_left);
                return true;
            case R.id.item3:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("username", extras.getString("username"));
                startActivity(intent);
                overridePendingTransition(R.anim.from_right, R.anim.to_left);
                return true;
        }
        return false;
    }
}