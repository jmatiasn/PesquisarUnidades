package br.ufrn.imd.matiasemarinheiro.pesquisaunidades;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText pesquisaEdt;
    private Button pesquisarBtn;
    private ProgressDialog progressDialog;
    private List<UnidadeDTO> unidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unidades = new ArrayList<UnidadeDTO>();

        pesquisaEdt = (EditText) findViewById(R.id.pesquisa_edt);
        pesquisarBtn = (Button) findViewById(R.id.pesquisar_btn);
    }

    public void pesquisarUnidade(View view) {

        //Copiado do projeto exemplo da api ufrn
        //Create a new progress dialog
        progressDialog = ProgressDialog.show(MainActivity.this, null, "Carregando dados da aplicação...", true);

        new Thread(new Runnable() {
            @Override
            public void run()
            {
                //Initialize a LoadViewTask object and call the execute() method
                String text = OltuJavaClient.getResource(pesquisaEdt.getText().toString());
                unidades = new ArrayList<UnidadeDTO>();
                if(!text.equalsIgnoreCase("")){
                    try {
                        JSONArray array = new JSONArray(text);
                        for(int i = 0; i < array.length(); ++i){
                            JSONObject jsonList = array.getJSONObject(i);

                            unidades.add(new UnidadeDTO(jsonList.getInt("codigoUnidade"),
                                    jsonList.getString("nomeUnidade"),
                                    jsonList.getString("email"),
                                    jsonList.getString("telefones")));
                        }

                        for(int i=0; i<unidades.size(); i++){
                            Log.d("myTag", "------- UNIDADE -----------");
                            Log.d("myTag", unidades.get(i).getNome());
                            Log.d("myTag", unidades.get(i).getTelefone());
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        progressDialog.dismiss();


                        Intent i  = new Intent(MainActivity.this, ListActivity.class);
                        i.putExtra("fornecedores", (Serializable) unidades);
                        startActivity(i);
                    }
                });
            }
        }).start();
    }
}
