package com.example.grupitoml.Interfaces;


import com.example.grupitoml.Model.Produto;
import com.example.grupitoml.Model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface NodeServer {

    @FormUrlEncoded
    @POST("/criar-usuario")
    Call<Usuario> criarUsuario(@Field("email") String email, @Field("nome") String nome, @Field("senha") String senha, @Field("telefone") String telefone);

    @FormUrlEncoded
    @PUT("/editar-usuario")
    Call<Usuario> EditarUsuario(@Field("email") String email, @Field("nome") String nome, @Field("senha") String senha, @Field("telefone") String telefone);

    @FormUrlEncoded
    @DELETE("/remover-usuario")
    Call<Usuario> RemoverUsuario(@Field("email") String email);

    @FormUrlEncoded
    @POST("/login")
    Call<Usuario> login(@Field("email") String email, @Field("senha") String senha);


    @FormUrlEncoded
    @GET("/listar-produtos")
    Call<Produto> listarProdutos();

    @FormUrlEncoded
    @POST("/criar-produto")
    Call<Produto> criarProduto(@Field("id") String id, @Field("nome") String nome, @Field("preco") Double preco, @Field("mensagem") String mensagem);

    @FormUrlEncoded
    @PUT("/editar-produto")
    Call<Produto> editarProduto(@Field("id") String id, @Field("nome") String nome, @Field("preco") Double preco, @Field("mensagem") String mensagem);

    @FormUrlEncoded
    @DELETE("/remover-produto")
    Call<Produto> RemoverProduto(@Field("id") String id);
}
