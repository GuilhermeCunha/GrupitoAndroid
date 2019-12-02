package com.example.grupitoml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupitoml.API.RetrofitClientInstance;
import com.example.grupitoml.Interfaces.NodeServer;
import com.example.grupitoml.Model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                NodeServer service = RetrofitClientInstance.getRetrofitInstance().create(NodeServer.class);
                Call<Usuario> call = service.login(strEmail, strSenha);

                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Seja bem vindo " + response.body().getNome(), Toast.LENGTH_SHORT);
                            toast.show();

                            Intent i = new Intent(getApplicationContext(), UsandoDrawer.class);
                            startActivity(i);
                        }else{
                            Log.e("ONRESPONSE","CREDENCIAIS INVÁLIDAS");
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Log.e("OSFAILURE", "NÃO OK");
                    }
                });
            }
        });
    }
}
