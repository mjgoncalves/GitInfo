package com.example.marcelo.retrofitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnGetUser;
    private EditText username;
    private String sUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: CREATED!!!");
        initWidgets();
       
        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sUsername = username.getText().toString();
                if (Utils.checkStringIfNull(sUsername)){

                    Toast.makeText(MainActivity.this, getString(R.string.username_needed), Toast.LENGTH_SHORT)
                            .show();
                }else {

                    getUser();
                }
            }
        });
    }

    private void initWidgets(){

        btnGetUser = findViewById(R.id.btn_getuser);
        username = findViewById(R.id.username);
    }
    private void getUser(){

        Intent intent = new Intent(MainActivity.this, UserActivity.class);
        intent.putExtra("USERNAME", sUsername);
        startActivity(intent);
    }

}
