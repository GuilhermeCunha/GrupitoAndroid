package com.example.grupitoml.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private int ID;
    private String Email;
    private String Nome;
    private String Senha;
    private String Telefone;

    public Usuario(int ID, String email, String nome, String senha, String telefone) {
        this.ID = ID;
        Email = email;
        Nome = nome;
        Senha = senha;
        Telefone = telefone;
    }

    private Usuario(Parcel in) {
        ID = in.readInt();
        Email = in.readString();
        Nome = in.readString();
        Senha = in.readString();
        Telefone = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Email);
        dest.writeString(Nome);
        dest.writeString(Senha);
        dest.writeString(Telefone);
    }
}
