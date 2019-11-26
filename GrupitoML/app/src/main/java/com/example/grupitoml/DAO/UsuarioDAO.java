package com.example.grupitoml.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.grupitoml.Backup.UsuarioBackupCriar;
import com.example.grupitoml.DB.DBOpenHelper;
import com.example.grupitoml.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public  boolean inserirUsuario(Usuario usuario, Context context){
        usuario.setEmail(usuario.getEmail().toLowerCase());
        long resultado;

        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("Email", usuario.getEmail());
        valores.put("Nome", usuario.getNome());
        valores.put("Senha", usuario.getSenha());
        valores.put("Telefone", usuario.getTelefone());

        resultado = db.insert("Usuarios", null, valores);
        db.close();
        Log.i("inserirUsuario", "Criado usado com sucesso");

        UsuarioBackupCriar usuarioBackupCriar = new UsuarioBackupCriar();
        usuarioBackupCriar.execute(usuario);

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

    public boolean alterarUsuario(Usuario usuario, Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        String where;
        try{
            where = "ID" + "=" + usuario.getID();


            valores.put("Email", usuario.getEmail());
            valores.put("Nome", usuario.getNome());
            valores.put("Senha", usuario.getSenha());
            valores.put("Telefone", usuario.getTelefone());

            db.update("Usuarios", valores, where,null);
            db.close();
            return true;
        }catch (SQLException e){
            Log.e("Erro", e.toString());
            return false;
        }

    }

    public boolean deletarUsuario(Usuario us, Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        try{
            String where = "ID" + "=" + us.getID();

            db.delete("Usuarios",where,null);
            db.close();
            return true;
        }catch (SQLException e){
            Log.e("Erro", e.toString());
            return false;
        }

    }
    public static boolean deletarUsuario(String email, Context context){
        Log.i("DELETARUSUARIO", "Entrando na funcao");
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        try{
            String table = "Usuarios";
            String whereClause = "Email=?";
            String[] whereArgs = new String[] {email};
            db.delete(table, whereClause, whereArgs);

            Log.i("DELETARUSUARIO", "USUARIO DELETADO");
            return true;
        }catch (SQLException e){
            Log.e("Erro", e.toString());
            return false;
        }finally {
            db.close();
        }

    }
    public boolean deletarUsuario(int id, Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        try{
            String where = "ID" + "=" + id;

            db.delete("Usuarios",where,null);
            db.close();
            return true;
        }catch (SQLException e){
            Log.e("Erro", e.toString());
            return false;
        }

    }

    public static boolean loginUsuario(String email, String senha, Context context){
        email = email.toLowerCase();
        Log.i("LOGINUSUARIO", email);
        Log.i("LOGINUSUARIO", senha);

        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        String sql = "SELECT * FROM Usuarios WHERE Email=? and Senha=?";

        Cursor cursor;

        cursor = db.rawQuery(sql, new String[]{email, senha});
        cursor.moveToFirst();
        Log.i("TAMANHOCURSOR", ""+ cursor.getCount());
        if (cursor.getCount() == 0)return false;
        return true;
    }
}

