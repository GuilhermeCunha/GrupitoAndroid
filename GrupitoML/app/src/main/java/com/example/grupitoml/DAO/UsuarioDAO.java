package com.example.grupitoml.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.grupitoml.DB.DBOpenHelper;
import com.example.grupitoml.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

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
    public static List<Usuario> listarUsuarios(Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        Cursor cursor;
        String TABELA = "Usuarios";
        String[] campos =  {"ID", "Email", "Nome", "Senha", "Telefone"};

        cursor = db.query(TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
            List<Usuario> usuarios = new ArrayList<>();
            while (!cursor.isAfterLast()){

                int ID = cursor.getInt(0);
                String email = cursor.getString(1);
                String nome = cursor.getString(2);
                String senha = cursor.getString(3);
                String telefone = cursor.getString(4);
                Usuario us = new Usuario(ID, email, nome, senha, telefone);
                usuarios.add(us);

                cursor.moveToNext();
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            return usuarios;
        }
        return null;
    }
}

