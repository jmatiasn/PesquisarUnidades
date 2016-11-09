package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.matiasemarinheiro.pesquisaunidades.R;
import br.ufrn.imd.matiasemarinheiro.pesquisaunidades.UnidadeDTO;

/**
 * Created by joaomatias on 09/11/16.
 */
public class UnidadesAdapter extends ArrayAdapter<UnidadeDTO> {


    private final Context context;
    private List<UnidadeDTO> unidades = new ArrayList<UnidadeDTO>();

    public UnidadesAdapter(Context context, List<UnidadeDTO> unidades) {
        super(context, R.layout.list_unidades, unidades);
        this.context = context;
        this.unidades = unidades;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_unidades, parent, false);

        UnidadeDTO item = unidades.get(position);

        TextView titleText = (TextView)
                view.findViewById(R.id.codigoText);
        titleText.setText( String.valueOf(item.getCodigo()) );

        TextView nomeText = (TextView)
                view.findViewById(R.id.nomeText);
        nomeText.setText( item.getNome() );

        TextView emailText = (TextView)
                view.findViewById(R.id.emailText);
        emailText.setText( item.getEmail() );

        TextView telefoneText = (TextView)
                view.findViewById(R.id.telefoneText);
        telefoneText.setText( item.getTelefone() );

        return view;
    }
}
