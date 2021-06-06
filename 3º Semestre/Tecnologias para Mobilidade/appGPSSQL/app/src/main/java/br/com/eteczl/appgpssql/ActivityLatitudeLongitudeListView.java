package br.com.eteczl.appgpssql;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;

public class ActivityLatitudeLongitudeListView extends AppCompatActivity {

    private ListView listView;
    private CursorAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_latitude_longitude_list_view);
        this.atualizarListView();
        registerForContextMenu(this.listView);
    }

    private void atualizarListView(){
        this.listView = (ListView) findViewById(R.id.listViewLatitudeLongitude);
        SqliteDBHelper sqliteDBHelper = new SqliteDBHelper(this);
        SQLiteDatabase sqLiteDatabase = sqliteDBHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query("TblCoordenadas",new String[]
                {"_id","latitude","longitude"},null,null,null,null,null,null);
        this.listViewAdapter = new ListViewCursorAdapter(this,cursor);

        listView.setAdapter(this.listViewAdapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.i("ActivityListView","public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo " +
                "menuInfo) {...");

        //Um context menu pode ser criado por outros componentes alem do nosso listview
        //Por isso a gente tem que testar pra ver qual componente esta criando o context menu

            if (v.getId()==R.id.listViewLatitudeLongitude) {
                menu.setHeaderIcon(null);
                menu.setHeaderTitle("Opcoes...");
                getMenuInflater().inflate(R.menu.context_menu_crud_operations, menu);
            }
        }

    private ListViewItemDTO getListViewItemDTOFromItem(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        ListViewItemDTO listViewItemDTO = new ListViewItemDTO();
        Cursor c = (Cursor) this.listViewAdapter.getItem(info.position);

        Log.i("@@@", "this.listViewAdapter.getItemId(info.position) = " + this.listViewAdapter.getItemId(info.position));
        listViewItemDTO.id = c.getInt(0);
        listViewItemDTO.latitude = c.getString(1);
        listViewItemDTO.longitude = c.getString(2);
        return listViewItemDTO;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        ListViewItemDTO listViewItemDTOFromItem = getListViewItemDTOFromItem(item);

        switch (item.getItemId()){
            case R.id.crud_ctx_mn_opt_editar:
                ActivityLatitudeLongitudeListView.this.editarListViewItem(listViewItemDTOFromItem);
                break;

            case R.id.crud_ctx_mn_opt_excluir:
                ActivityLatitudeLongitudeListView.this.excluirListViewItem(listViewItemDTOFromItem);
                break;

            case R.id.crud_ctx_mn_opt_novo:
                ActivityLatitudeLongitudeListView.this.novoListViewItem(listViewItemDTOFromItem);
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void editarListViewItem(ListViewItemDTO listViewItemDTO){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("id", listViewItemDTO.id);
        i.putExtra("latitude", listViewItemDTO.latitude);
        i.putExtra("longitude", listViewItemDTO.longitude);
        startActivity(i);
    }

    public void excluirListViewItem(ListViewItemDTO listViewItemDTO){
        SQLiteDatabase db = new SqliteDBHelper(this).getWritableDatabase();
        db.delete("TblCoordenadas","_id = "+listViewItemDTO.id,null);
        this.atualizarListView();
    }

    public void novoListViewItem(ListViewItemDTO listViewItemDTO){
        Intent i  = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
