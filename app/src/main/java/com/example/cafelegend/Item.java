package com.example.cafelegend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cafelegend.adapter.FragmentAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Vector;

public class Item extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Bundle extras;
    //Side Navbar
    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;

    //Tab Control / Layout
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;

    void setDrawer(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    void init(){
        extras = getIntent().getExtras();

        //Side Navbar
        drawerLayout = findViewById(R.id.drawerLayoutItem);
        navView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);

        //Tab Control / Layout
        tabLayout = findViewById(R.id.tabLayoutItem);
        viewPager2 = findViewById(R.id.viewPager2Item);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Appetizer"));
        tabLayout.addTab(tabLayout.newTab().setText("Main Course"));
        tabLayout.addTab(tabLayout.newTab().setText("Beverage"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.item1:
                intent = new Intent(this, Home.class);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        init();
        setDrawer();
    }
}