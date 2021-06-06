package com.example.wagner.sqlite_crud_project;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by wagner on 25/04/16.
 */
public class ListViewAdapterForSqliteCursor extends CursorAdapter {


    public ListViewAdapterForSqliteCursor (Context context, Cursor cursor) {
        super(context, cursor, 0);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.listview_item_latitudelongitude, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView textViewId = (TextView) view.findViewById(R.id.TextViewId);
        TextView textViewLatitude = (TextView) view.findViewById(R.id.TextViewLatitude);
        TextView textViewLongitude = (TextView) view.findViewById(R.id.TextViewLongitude);
        // Extract properties from cursor
        String _id  = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String latitude = cursor.getString(cursor.getColumnIndexOrThrow("Latitude"));
        String longitude = cursor.getString(cursor.getColumnIndexOrThrow("Longitude"));
        // Populate fields with extracted propertie
        textViewId.setText(_id);
        textViewLatitude.setText(latitude);
        textViewLongitude.setText(longitude);

    }
}
