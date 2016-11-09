package br.ufrn.imd.matiasemarinheiro.pesquisaunidades;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.List;

import adapters.UnidadesAdapter;

/**
 * Created by joaomatias e fabianamarinheiro on 09/11/16.
 */
public class ListActivity extends AppCompatActivity {

    private ListView fornecedoresListView;
    private UnidadesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        fornecedoresListView = (ListView) findViewById(R.id.listunidades);

        List<UnidadeDTO> fornecedores = (List<UnidadeDTO>)
                getIntent().getSerializableExtra("fornecedores");

        fornecedoresListView.setAdapter(new UnidadesAdapter(this, fornecedores));
    }
}
