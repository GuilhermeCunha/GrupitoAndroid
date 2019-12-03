package com.example.grupitoml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.grupitoml.Fragments.ProdutoFragment;
import com.google.android.material.navigation.NavigationView;

public class MenuPrincipalActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        //init();
    }

/*
    private void init(){
        NavController navController = Navigation.findNavController(this,R.id.produtoFragment);
        NavigationUI.setupActionBarWithNavController(this, drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);
        navigationView.setNavigationItemSelectedListener(this);

    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.nav_cadproduto:{
                Intent intente = new Intent(getApplicationContext(),CadastroProduto.class);
                startActivity(intente);

                break;

            }

            case R.id.nav_visuproduto:{

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flProduto,new ProdutoFragment());
                ft.commit();
                break;

            }

            case R.id.nav_sobre:{

                break;

            }

        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
