package br.com.eteczl.appgpssql;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
/**
 * Created by Aluno_2 on 02/05/2016.
 */
public class ListViewCursorAdapter extends CursorAdapter{

    public ListViewCursorAdapter(Context context, Cursor c){
        super(context, c, 0);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.listview_item_latitude_longitude,parent,false);
    }

    public void bindView(View view, Context context, Cursor cursor){
        // Find fields to populate in inflated template
        TextView textView1 = (TextView) view.findViewById(R.id.textView1);
        TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        TextView textView3 = (TextView) view.findViewById(R.id.textView3);

        // Extract properties from cursor
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String latitude = cursor.getString(cursor.getColumnIndexOrThrow("latitude"));
        String longitude = cursor.getString(cursor.getColumnIndexOrThrow("longitude"));

        textView1.setText(String.valueOf(id));
        textView2.setText(latitude);
        textView3.setText(longitude);
    }
}
