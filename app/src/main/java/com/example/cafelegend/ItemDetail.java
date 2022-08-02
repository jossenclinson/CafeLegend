package com.example.cafelegend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class ItemDetail extends AppCompatActivity {
    ImageView backItemIV, detailImageIV;
    TextView detailNameTV, detailPriceTV, detailDescTV;
    Bundle extras;

    void init(){
        backItemIV = findViewById(R.id.backItemIV);

        detailImageIV = findViewById(R.id.detailImageIV);
        detailNameTV = findViewById(R.id.detailNameTV);
        detailPriceTV = findViewById(R.id.detailPriceTV);
        detailDescTV = findViewById(R.id.detailDescTV);

        extras = getIntent().getExtras();
        detailImageIV.setImageResource(extras.getInt("detailImage"));
        detailNameTV.setText(extras.getString("detailName"));
        detailPriceTV.setText("IDR " + extras.getInt("detailPrice"));
        detailDescTV.setText(extras.getString("detailDesc"));
    }

    void eventBtn(){
        backItemIV.setOnClickListener(x -> {
            finish();
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        init();
        eventBtn();
    }
}