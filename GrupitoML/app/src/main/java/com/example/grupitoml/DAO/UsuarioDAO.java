package com.example.grupitoml.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.grupitoml.DB.DBOpenHelper;
import com.example.grupitoml.Model.Usuario;

public class UsuarioDAO {
    public static boolean inserirUsuario(Usuario usuario, Context context){
        long resultado;

        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("Email", usuario.getEmail());
        valores.put("Nome", usuario.getNome());
        valores.put("Senha", usuario.getSenha());
        valores.put("Telefone", usuario.getTelefone());

        resultado = db.insert("Usuario", null, valores);
        db.close();

        return resultado != -1;

    }
}
