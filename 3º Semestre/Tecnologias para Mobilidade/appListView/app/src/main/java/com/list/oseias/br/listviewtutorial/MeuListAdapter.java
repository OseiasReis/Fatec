package com.list.oseias.br.listviewtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Escola on 24/06/2016.
 */
public class MeuListAdapter extends ArrayAdapter{

    public MeuListAdapter(Context context, int resource, List objects){
        super(context, resource, objects);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            v = layoutInflater.inflate(R.layout.linha_da_list_view, null);
        }else{
            //NESTE PONTO A v JÁ FOI CRIADA E NÃO PRECISA MAIS SER INFLADA...
        }

        Task t = (Task) getItem(position);

        if(t != null){

            TextView tvTaskDesc = (TextView) v.findViewById(R.id.txtViewDescricao);
            TextView tvTaskData = (TextView) v.findViewById(R.id.txtVData);

            if(tvTaskDesc != null) tvTaskDesc.setText(t.getDescricao());
            if(tvTaskData != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                String dtaFormatada = sdf.format(t.getDtaFinal());
                tvTaskData.setText(dtaFormatada);
            }
        }
        return v;
    }
}
