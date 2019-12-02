package com.example.grupitoml.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.grupitoml.Model.Produto;
import com.example.grupitoml.R;

public class DetalheProdutoAtividade extends AppCompatActivity {

    public static final String EXTRA_PRODUTO = "aluno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto_atividade);

        Intent intent = getIntent();
        Produto produto = (Produto)
                intent.getSerializableExtra(EXTRA_PRODUTO);
        DetalheProdutoFragment fragment =
                DetalheProdutoFragment.novaInstancia(produto);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.detalhe, fragment,
                DetalheProdutoFragment.TAG_DETALHE);
        ft.commit();
    }
}
