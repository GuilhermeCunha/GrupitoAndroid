package com.example.grupitoml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private String strEmail;
    private EditText senha;
    private String strSenha;
    private TextView cadastro;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email =(EditText) findViewById(R.id.EdtEmail);
        senha =(EditText) findViewById(R.id.EdtSenha);
        cadastro =(TextView) findViewById(R.id.TxtCadastro);
        login =(Button) findViewById(R.id.BtnLogin);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroUsuario.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEmail= email.getText().toString();
                strSenha= senha.getText().toString();
            }
        });
    }
}
