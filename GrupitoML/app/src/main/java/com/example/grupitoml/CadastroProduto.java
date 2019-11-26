package com.example.grupitoml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroProduto extends AppCompatActivity {
    private EditText nome;
    private String strNome;
    private EditText preco;
    private double doublePreco;
    private EditText mensagem;
    private String strMensagem;
    private Button publicar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        nome =(EditText) findViewById(R.id.EdtNome);
        preco =(EditText) findViewById(R.id.EdtPreco);
        mensagem =(EditText) findViewById(R.id.EdtMensagem);
        publicar =(Button) findViewById(R.id.BtnPublicar);
        publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNome = nome.getText().toString();
                strMensagem = mensagem.getText().toString();
                doublePreco = Double.parseDouble(preco.getText().toString());

            }
        });
    }
}
