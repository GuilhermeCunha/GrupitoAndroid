package com.example.grupitoml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.splash_layout);

        
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override public void run() {
                mostrarLogin();
            }
        }, 2000);
    }

    private void mostrarLogin() {
        /*
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();*/
    }
}
