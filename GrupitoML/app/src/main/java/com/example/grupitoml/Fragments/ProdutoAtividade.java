package com.example.grupitoml.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.grupitoml.Model.Produto;
import com.example.grupitoml.R;

import java.io.Serializable;

public class ProdutoAtividade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_atividade);
    }
    private boolean isTablet()
    {
        return findViewById(R.id.detalhe) !=null;
        //        return getResources().getBoolean(R.bool.tablet);
    }
    private boolean isSmartphone()
    {
        return getResources().getBoolean(R.bool.smartphone);
    }

    public void clicouNoProduto(Produto produto){
        if (isTablet()) {
            DetalheProdutoFragment fragment = DetalheProdutoFragment.novaInstancia(produto);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe, fragment, DetalheProdutoFragment.TAG_DETALHE);
            ft.commit();
        } else if(isSmartphone()) {
            Intent it = new Intent(this, DetalheProdutoFragment.class);
            it.putExtra(DetalheProdutoFragment.EXTRA_PRODUTO, (Serializable) produto);
            startActivity(it);
        }
    }


}
