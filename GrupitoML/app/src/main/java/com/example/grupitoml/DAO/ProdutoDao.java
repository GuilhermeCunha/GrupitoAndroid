package com.example.grupitoml.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.grupitoml.DB.DBOpenHelper;
import com.example.grupitoml.Model.Produto;
import com.example.grupitoml.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {


    public boolean inserirProduto(Produto produto, Context context){
        long resultado;

        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("Url", produto.getUrl());
        valores.put("Mensagem", produto.getMensagem());
        valores.put("Preco", produto.getPreco());

        resultado = db.insert("Produto", null, valores);
        db.close();

        return resultado != -1;

    }

    public static List<Produto> listarProdutos(Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        Cursor cursor;
        String TABELA = "Produtos";
        String[] campos =  {"ID", "Url", "Mensagem", "Preco"};

        cursor = db.query(TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
            List<Produto> produtos = new ArrayList<>();
            while (!cursor.isAfterLast()){

                int ID = cursor.getInt(0);
                String url = cursor.getString(1);
                String mensagem = cursor.getString(2);
                Double preco = cursor.getDouble(3);
                Produto prod = new Produto(ID, url, mensagem, preco);
                produtos.add(prod);

                cursor.moveToNext();
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            return produtos;
        }
        return null;
    }

    public boolean alterarProduto(Produto produto, Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        String where;
        try{
            where = "ID" + "=" + produto.getID();


            valores.put("Url", produto.getUrl());
            valores.put("Mensagem", produto.getMensagem());
            valores.put("Preco", produto.getPreco());

            db.update("Produtos", valores, where,null);
            db.close();
            return true;
        }catch (SQLException e){
            Log.e("Erro", e.toString());
            return false;
        }

    }

    public boolean deletarProduto(int id, Context context){
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context);
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        try{
            String where = "ID" + "=" + id;

            db.delete("Produtos",where,null);
            db.close();
            return true;
        }catch (SQLException e){
            Log.e("Erro", e.toString());
            return false;
        }

    }
}
