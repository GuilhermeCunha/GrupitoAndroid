package com.example.grupitoml.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.grupitoml.DAO.ProdutoDao;
import com.example.grupitoml.Model.Produto;
import com.example.grupitoml.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutoFragment extends ListFragment {

    List<Produto> produtos;
    ArrayAdapter<Produto> adapter;


    public ProdutoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        produtos = ProdutoDao.listarProdutos(getContext());
        adapter = new ArrayAdapter<Produto>(getActivity(), android.R.layout.simple_list_item_1, produtos);
        setListAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_produto, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Activity activity = getActivity();
        if (activity instanceof AoClicarNoProduto) {
            Produto produto = (Produto) l.getItemAtPosition(position);
            AoClicarNoProduto listener = (AoClicarNoProduto) activity;
            listener.clicouNoProduto(produto);
        }


    }

    public interface AoClicarNoProduto {
        void clicouNoProduto(Produto produto);
    }

}
