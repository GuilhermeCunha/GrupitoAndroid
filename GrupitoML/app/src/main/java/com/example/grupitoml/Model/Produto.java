package com.example.grupitoml.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Produto implements Parcelable, Serializable {
    private int ID;
    private String Url;
    private String Mensagem;
    private Double Preco;

    public Produto(int ID, String url, String mensagem, Double preco) {
        this.ID = ID;
        Url = url;
        Mensagem = mensagem;
        Preco = preco;
    }

    private Produto(Parcel in) {
        ID = in.readInt();
        Url = in.readString();
        Mensagem = in.readString();
        if (in.readByte() == 0) {
            Preco = null;
        } else {
            Preco = in.readDouble();
        }
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double preco) {
        Preco = preco;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Url);
        dest.writeString(Mensagem);
        if (Preco == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(Preco);
        }
    }
}
