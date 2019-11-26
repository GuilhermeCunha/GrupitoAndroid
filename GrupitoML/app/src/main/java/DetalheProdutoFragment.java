import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.grupitoml.Model.Produto;
import com.example.grupitoml.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheProdutoFragment extends Fragment {
    public static final String TAG_DETALHE = "tagDetalhe";
    public static final String EXTRA_PRODUTO = "produto";
    TextView mUrl;
    TextView mMensagem;
    TextView mPreco;

    Produto produto;




    public static DetalheProdutoFragment novaInstancia(Produto produto) {
        Bundle parametros = new Bundle();
        parametros.putSerializable(EXTRA_PRODUTO,produto);
        DetalheProdutoFragment fragment = new DetalheProdutoFragment();
        fragment.setArguments(parametros);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        produto = (Produto)
                getArguments().getSerializable(EXTRA_PRODUTO);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(
                R.layout.fragment_detalhe_produto, container, false);
        mUrl = (TextView)layout.findViewById(R.id.txtUrl);
        mMensagem = (TextView)
                layout.findViewById(R.id.txtMensagem);
        mPreco = (TextView)
                layout.findViewById(R.id.txtPreco);
        if (produto!= null) {
            mUrl.setText(produto.getUrl());
            mMensagem.setText(produto.getMensagem());
            mPreco.setText(String.valueOf(produto.getPreco()));
        }
        return layout;
    }

}
