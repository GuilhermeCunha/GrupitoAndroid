package com.example.grupitoml.Backup;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.example.grupitoml.API.CallbackWithRetry;
import com.example.grupitoml.API.RetrofitClientInstance;
import com.example.grupitoml.Interfaces.NodeServer;
import com.example.grupitoml.Model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuarioBackupCriar extends AsyncTask<Usuario, Void, Void> {

    @Override
    protected Void doInBackground(Usuario... usuarios) {

        final Boolean sucesso = false;

        NodeServer service = RetrofitClientInstance.getRetrofitInstance().create(NodeServer.class);
        Call<Usuario> call = service.criarUsuario(usuarios[0].getEmail(),
                usuarios[0].getNome(), usuarios[0].getSenha(), usuarios[0].getTelefone());
        call.enqueue(new CallbackWithRetry<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.i("USUARIOBACKUP", "SUCESSO");
            }
        });
        return null;
    }
}
