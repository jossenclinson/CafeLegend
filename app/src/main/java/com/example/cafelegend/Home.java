package com.example.cafelegend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    TextView welcomeTV;
    Bundle extras;
    ImageView carouselBackIV, carouselNextIV;
    ViewFlipper vf_flipper, vf_food1, vf_food2, vf_drink1, vf_drink2;

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

        carouselBackIV = findViewById(R.id.carouselBackIV);
        carouselNextIV = findViewById(R.id.carouselNextIV);

        vf_flipper = findViewById(R.id.vf_flipper);
        vf_food1 = findViewById(R.id.vf_food1);
        vf_food2 = findViewById(R.id.vf_food2);
        vf_drink1 = findViewById(R.id.vf_drink1);
        vf_drink2 = findViewById(R.id.vf_drink2);

    }

    void setEvent(){
        carouselBackIV.setOnClickListener(x -> {
            vf_flipper.setInAnimation(this, android.R.anim.slide_in_left);
            vf_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
            vf_flipper.showPrevious();
        });

        carouselNextIV.setOnClickListener(x -> {
            vf_flipper.setInAnimation(this, R.anim.slide_in_right);
            vf_flipper.setOutAnimation(this, R.anim.slide_out_left);
            vf_flipper.showNext();
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int[] images = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
        int[] food1 = {R.drawable.kebab, R.drawable.ramen, R.drawable.filipino_lumpia, R.drawable.korean_pancake};
        int[] food2 = {R.drawable.sushi, R.drawable.rendang, R.drawable.tomyam_goong, R.drawable.gravlax};
        int[] drink1 = {R.drawable.pina_colada, R.drawable.mango_lassi, R.drawable.cendol, R.drawable.eggnog};
        int[] drink2 = {R.drawable.avocado_juice, R.drawable.coffe_latte, R.drawable.ice_tea, R.drawable.chocolate_milkshake};
        init();
        setDrawer();

        for(int image: images){
            flipperImages(image);
        }

        for(int food1Img: food1){
            flipperFood1(food1Img);
        }

        for(int food2Img: food2){
            flipperFood2(food2Img);
        }

        for(int drink1Img: drink1){
            flipperDrink1(drink1Img);
        }

        for(int drink2Img: drink2){
            flipperDrink2(drink2Img);
        }
        setEvent();

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vf_flipper.addView(imageView);
        vf_flipper.setFlipInterval(5000);
        vf_flipper.setAutoStart(false);

        vf_flipper.setInAnimation(this, R.anim.slide_in_right);
        vf_flipper.setOutAnimation(this, R.anim.slide_out_left);
        vf_flipper.startFlipping();

    }

    public void flipperFood1(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vf_food1.addView(imageView);
        vf_food1.setFlipInterval(3000);
        vf_food1.setAutoStart(true);

        vf_food1.setInAnimation(this, R.anim.slide_up);
        vf_food1.setOutAnimation(this, R.anim.up_bottom);

    }

    public void flipperFood2(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vf_food2.addView(imageView);
        vf_food2.setFlipInterval(3000);
        vf_food2.setAutoStart(true);

        vf_food2.setInAnimation(this, R.anim.slide_up);
        vf_food2.setOutAnimation(this, R.anim.up_bottom);

    }

    public void flipperDrink1(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vf_drink1.addView(imageView);
        vf_drink1.setFlipInterval(3000);
        vf_drink1.setAutoStart(true);

        vf_drink1.setInAnimation(this, R.anim.slide_up);
        vf_drink1.setOutAnimation(this, R.anim.up_bottom);

    }

    public void flipperDrink2(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vf_drink2.addView(imageView);
        vf_drink2.setFlipInterval(3000);
        vf_drink2.setAutoStart(true);

        vf_drink2.setInAnimation(this, R.anim.slide_up);
        vf_drink2.setOutAnimation(this, R.anim.up_bottom);

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