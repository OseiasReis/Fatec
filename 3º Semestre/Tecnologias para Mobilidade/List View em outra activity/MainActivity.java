package com.example.wagner.sqlite_crud_project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ListViewItemDTO listViewItemDTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "#######################################################");
        Log.i("MainActivity", "protected void onCreate(Bundle savedInstanceState) {...");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



            Button btnMostra = (Button) findViewById(R.id.btnMostra);
            btnMostra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), ActivityLatitudeLongitudeListView.class);
                    startActivity(i);

                }
            });




        final Bundle extras1 = getIntent().getExtras();
        Button btnSalvaCoords = (Button) findViewById(R.id.btnSalvarCoord);


        if((null != extras1) && (extras1.get("id") != null)){
            Log.i("MainActivity", "onCreate: extras1.toString() =" +extras1.toString());
            Log.i("MainActivity", "onCreate: extras1.toString() =" +extras1.toString());
            Log.i("MainActivity", "onCreate: extras1.toString() =" +extras1.toString());

            this.listViewItemDTO = new ListViewItemDTO();
            this.listViewItemDTO.id = (int)extras1.get("id");
            this.listViewItemDTO.latitude = extras1.get("latitude").toString();
            this.listViewItemDTO.longitude = extras1.get("longitude").toString();

            EditText editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
            EditText editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);

            editTextLatitude.setText(this.listViewItemDTO.latitude);
            editTextLongitude.setText(this.listViewItemDTO.longitude);


            btnSalvaCoords.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("MainActivity", "btnSalvaCoords...!!!EDITANDO!!! COORDENADAS");
                    if(MainActivity.this.listViewItemDTO != null) {
                        SQLiteDatabase sqliteDatabase = new SqliteDBHelper(getApplicationContext()).getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        EditText editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
                        EditText editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);
                        cv.put("Latitude", editTextLatitude.getText().toString());
                        cv.put("Longitude", editTextLongitude.getText().toString());
                        sqliteDatabase.update(
                                "TblCoordenadas", cv, "_id = " + MainActivity.this.listViewItemDTO.id, null);
                        MainActivity.this.listViewItemDTO = null;
                    }//if(MainActivity.this.listViewItemDTO != null){
                }
            });

        }else{

            btnSalvaCoords.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("MainActivity", "btnSalvaCoords...SALVANDO COORDENADAS");
                    SQLiteDatabase sqliteDatabase = new SqliteDBHelper(getApplicationContext()).getWritableDatabase();
                    ContentValues cv = new ContentValues();
                    EditText editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
                    EditText editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);
                    cv.put("Latitude", editTextLatitude.getText().toString());
                    cv.put("Longitude", editTextLongitude.getText().toString());
                    sqliteDatabase.insert("TblCoordenadas", null, cv);
                }
            });


        }
    }//oncreate



    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "protected void onResume() {...");
//        Bundle extras = getIntent().getExtras();
//
//        Button btnSalvaCoords = (Button) findViewById(R.id.btnSalvarCoord);
//        if((null != extras) && (extras.get("id") != null)){
//            Log.i("MainActivity", "onResume: extras.toString() = "+extras.toString());
//            Log.i("MainActivity", "onResume: extras.size() = " + extras.size());
//            Log.i("MainActivity", "onResume: extras.keySet().toString() = " + extras.keySet().toString());
//
//            btnSalvaCoords.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.i("MainActivity", "onResume: btnSalvaCoords...!!!EDITANDO!!! COORDENADAS");
//                    Bundle extras = MainActivity.this.getIntent().getExtras();
//                    SQLiteDatabase sqliteDatabase = new SqliteDBHelper(getApplicationContext()).getWritableDatabase();
//                    ContentValues cv = new ContentValues();
//                    EditText editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
//                    EditText editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);
//                    Log.i("MainActivity", "onResume: extras.get(\"latitude\").toString() = "+extras.get("latitude").toString());
//                    Log.i("MainActivity", "onResume: extras.get(\"longitude\").toString() = "+extras.get("longitude").toString());
//                    editTextLatitude.setText(extras.get("latitude").toString());
//                    editTextLongitude.setText(extras.get("longitude").toString());
//                    cv.put("Latitude", editTextLatitude.getText().toString());
//                    cv.put("Longitude", editTextLongitude.getText().toString());
//                    sqliteDatabase.update("TblCoordenadas", cv, "_id = " + extras.get("id").toString(),null);
//                }
//            });
//
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}//class
