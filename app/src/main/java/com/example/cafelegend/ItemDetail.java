package com.example.cafelegend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class ItemDetail extends AppCompatActivity {
    ImageView backItemIV, detailImageIV;
    TextView detailNameTV, detailPriceTV, detailDescTV;
    Bundle extras;
    Button buyBtn;
    EditText quantityET ;

    void init(){
        backItemIV = findViewById(R.id.backItemIV);
        buyBtn = findViewById(R.id.buyBtn);

        detailImageIV = findViewById(R.id.detailImageIV);
        detailNameTV = findViewById(R.id.detailNameTV);
        detailPriceTV = findViewById(R.id.detailPriceTV);
        detailDescTV = findViewById(R.id.detailDescTV);

        extras = getIntent().getExtras();
        detailImageIV.setImageResource(extras.getInt("detailImage"));
        detailNameTV.setText(extras.getString("detailName"));
        detailPriceTV.setText("IDR " + extras.getInt("detailPrice"));
        detailDescTV.setText(extras.getString("detailDesc"));

        quantityET = findViewById(R.id.quantityET);
    }

    void eventBtn(){
        backItemIV.setOnClickListener(x -> {
            finish();
        });
    }

    void eventBuyBtn(){
        buyBtn.setOnClickListener(x ->{
            if (quantityET.getText().toString().isEmpty()){
                alert("Quantity must be greater than 0");
            }else {
                Integer quantity = Integer.parseInt(quantityET.getText().toString());
                if (quantity <= 0) {
                    alert("Quantity must be greater than 0");
                }else{
                    success("Success Buy " + extras.getString("detailName"));
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        init();
        eventBtn();
        eventBuyBtn();
    }

    private void alert(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(ItemDetail.this)
                .setTitle("ERROR")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        alertDialog.show();
    }

    private void success(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(ItemDetail.this)
                .setTitle("Success")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                })
                .create();
        alertDialog.show();
    }
}