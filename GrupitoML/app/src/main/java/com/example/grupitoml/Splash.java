package com.example.grupitoml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.grupitoml.DAO.UsuarioDAO;
import com.example.grupitoml.DB.DBOpenHelper;
import com.example.grupitoml.Model.Usuario;

import java.util.List;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.splash_layout);
        Log.i("Splash", "Entrando no SPLASH...");

        Handler handle = new Handler();

        handle.postDelayed(new Runnable() {
            @Override public void run() {
                mostrarLogin();
            }
        }, 2000);
        mostrarLogin();
    }

    private void mostrarLogin() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
