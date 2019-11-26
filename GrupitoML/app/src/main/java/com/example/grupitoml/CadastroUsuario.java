package com.example.grupitoml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroUsuario extends AppCompatActivity {
    private EditText email;
    private String strEmail;
    private EditText senha;
    private String strSenha;
    private EditText nome;
    private String strNome;
    private EditText telefone;
    private String strTelefone;
    private Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        email =(EditText) findViewById(R.id.EdtEmail);
        senha =(EditText) findViewById(R.id.EdtSenha);
        nome =(EditText) findViewById(R.id.EdtNome);
        telefone =(EditText) findViewById(R.id.EdtTelefone);
        confirmar =(Button) findViewById(R.id.BtnConfirmar);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail= email.getText().toString();
                strSenha= senha.getText().toString();
                strNome= nome.getText().toString();
                strTelefone= telefone.getText().toString();
            }
        });
    }
}
