package com.example.grupitoml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupitoml.DAO.UsuarioDAO;
import com.example.grupitoml.Model.Usuario;

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

    UsuarioDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        email =(EditText) findViewById(R.id.editEmailCadastro);
        senha =(EditText) findViewById(R.id.EdtSenha);
        nome =(EditText) findViewById(R.id.EdtNome);
        telefone =(EditText) findViewById(R.id.EdtTelefone);
        confirmar =(Button) findViewById(R.id.BtnConfirmar);
        dao = new UsuarioDAO();
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario U = new Usuario();

                U.setEmail(email.getText().toString().toLowerCase().trim());
                U.setSenha(senha.getText().toString());
                U.setNome(nome.getText().toString());
                U.setTelefone(telefone.getText().toString());
                dao.inserirUsuario( U,getApplicationContext());
                Toast.makeText(getBaseContext(),"usuario inserido ",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
