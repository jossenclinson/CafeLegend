package com.example.cafelegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText usernameET, passwordET;
    Button loginBtn;
    TextView errorTV;

    void init(){
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        errorTV = findViewById(R.id.errorTV);
    }

    void eventBtn(){
        loginBtn.setOnClickListener(x -> {
            String username = usernameET.getText().toString();
            String password = passwordET.getText().toString();
            if(username.equals("") || password.equals("")){
                errorTV.setText("Field can't be empty!");
                errorTV.setVisibility(View.VISIBLE);
            }
            else if(username.length() < 5 || username.length() > 20){
                errorTV.setText("Username's length must between 5 and 20");
                errorTV.setVisibility(View.VISIBLE);
            }
            else if(!password.matches("^[a-zA-Z0-9]*$")){
                errorTV.setText("Password must alphanumeric");
                errorTV.setVisibility(View.VISIBLE);
            }
            else if(password.matches("^[a-zA-Z]*$") && !password.matches("^[0-9]*$")){
                errorTV.setText("Password must contain number");
                errorTV.setVisibility(View.VISIBLE);
            }
            else if(!password.matches("^[a-zA-Z]*$") && password.matches("^[0-9]*$")){
                errorTV.setText("Password must contain character");
                errorTV.setVisibility(View.VISIBLE);
            }
            else{
                Intent intent = new Intent(this, Home.class);
                intent.putExtra("username", usernameET.getText().toString());
                intent.putExtra("password", passwordET.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        eventBtn();
//        Toast.makeText(this, "You clicked Find Us", Toast.LENGTH_SHORT).show();

        // Untuk langsung direct ke halaman masing-masing
        Intent intent = new Intent(this, Item.class);
        startActivity(intent);
    }
}