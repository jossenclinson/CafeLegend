package com.example.cafelegend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cafelegend.adapter.FragmentAdapter;
import com.example.cafelegend.adapter.RvAdapter;
import com.example.cafelegend.model.ItemList;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Vector;

public class Item extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Side Navbar
    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;

    //Tab Control / Layout
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;

    //Repeater
    RecyclerView appetizerRV, mainCourseRV, beverageRV;
    Vector<ItemList> appetizerVector, mainCourseVector, beverageVector;
    RvAdapter adapter;

    void setDrawer(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    void loadDataRV(){
        appetizerVector = new Vector<>();
        appetizerVector.add(new ItemList("Gravlax", 34000));
        appetizerVector.add(new ItemList("Korean Pancake", 23000));
        appetizerVector.add(new ItemList("Mexican Queso Fundido", 30000));
        appetizerVector.add(new ItemList("Malaysian Chicken Satay", 22000));
        appetizerVector.add(new ItemList("Filipino Lumpia", 24500));

        mainCourseVector = new Vector<>();
        mainCourseVector.add(new ItemList("Rendang", 75000));
        mainCourseVector.add(new ItemList("Sushi", 55000));
        mainCourseVector.add(new ItemList("Ramen", 35000));
        mainCourseVector.add(new ItemList("Tom Yam Goong", 59900));
        mainCourseVector.add(new ItemList("Kebab", 42800));

        beverageVector = new Vector<>();
        beverageVector.add(new ItemList("Mango Lassi", 25000));
        beverageVector.add(new ItemList("Pina Colada", 28000));
        beverageVector.add(new ItemList("Cendol", 17000));
        beverageVector.add(new ItemList("Chocolate Milkshake", 64000));
        beverageVector.add(new ItemList("Eggnog", 65000));
    }

    void init(){
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

        //Repeater
//        appetizerRV = findViewById(R.id.appetizerRV);
//        mainCourseRV = findViewById(R.id.mainCourseRV);
//        beverageRV = findViewById(R.id.beverageRV);
//        loadDataRV();
//        adapter = new RvAdapter(this);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()){
//                    case 0:
//                        adapter.setItemVector(appetizerVector);
//                        appetizerRV.setAdapter(adapter);
//                        appetizerRV.setLayoutManager(new GridLayoutManager(Item.this, 1));
//                        break;
//                    case 1:
//                        adapter.setItemVector(mainCourseVector);
//                        mainCourseRV.setAdapter(adapter);
//                        mainCourseRV.setLayoutManager(new GridLayoutManager(Item.this, 1));
//                        break;
//                    case 2:
//                        adapter.setItemVector(beverageVector);
//                        beverageRV.setAdapter(adapter);
//                        beverageRV.setLayoutManager(new GridLayoutManager(Item.this, 1));
//                        break;
//                }
                Toast.makeText(Item.this, "Clicked " + tab.getPosition(), Toast.LENGTH_SHORT).show();

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
                startActivity(intent);
                overridePendingTransition(R.anim.from_right, R.anim.to_left);
                return true;
            case R.id.item2:
                intent = new Intent(this, FindUs.class);
                startActivity(intent);
                overridePendingTransition(R.anim.from_right, R.anim.to_left);
                return true;
            case R.id.item3:
                intent = new Intent(this, MainActivity.class);
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