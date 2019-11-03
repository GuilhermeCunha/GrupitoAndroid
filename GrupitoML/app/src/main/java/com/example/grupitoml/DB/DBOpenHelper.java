package com.example.grupitoml.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GrupitoDB";
    public static final int DATABASE_VERSION = 1;


    private static final String SQL_CREATE_USUARIOS = "" +
            "CREATE TABLE IF NOT EXISTS Usuarios (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Email TEXT," +
            "Nome TEXT," +
            "Senha TEXT," +
            "Telefone TEXT);";

    private static final String SQL_CREATE_PRODUTOS = "" +
            "CREATE TABLE IF NOT EXISTS Produtos (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Url TEXT," +
            "Mensagem TEXT," +
            "Preco REAL);";


    private static final String SQL_DELETE_USUARIOS =
            "DROP TABLE IF EXISTS Usuarios";

    private static final String SQL_DELETE_PRODUTOS =
            "DROP TABLE IF EXISTS Produtos";



    public DBOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USUARIOS);
        db.execSQL(SQL_CREATE_PRODUTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_USUARIOS);
            db.execSQL(SQL_DELETE_PRODUTOS);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
