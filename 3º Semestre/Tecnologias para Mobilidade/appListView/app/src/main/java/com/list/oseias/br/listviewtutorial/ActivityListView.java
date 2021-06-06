package com.list.oseias.br.listviewtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;
import java.util.List;

public class ActivityListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_list_view);

        ListView listView = (ListView) findViewById(R.id.listView);

        Collection<Task> listaDeObjetosTarefa = new TaskDao().listarTudo();

        ArrayAdapter listViewAdapter = new MeuListAdapter(this, R.layout.linha_da_list_view, (List) listaDeObjetosTarefa);

        listView.setAdapter(listViewAdapter);
    }
}
