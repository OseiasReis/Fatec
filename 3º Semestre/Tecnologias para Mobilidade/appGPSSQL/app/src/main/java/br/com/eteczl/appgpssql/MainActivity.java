package br.com.eteczl.appgpssql;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText etlati;
    private EditText etlonge;
    private Button btnlocal;
    private ListViewItemDTO listViewItemDTO;

    @Override
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupElements();

        Button btnsalvar = (Button) findViewById(R.id.btnsalvar);
        btnsalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /*Log.i("MainActivity", "btnSalvarCoords...Salvando COORDENADAS");
                SQLiteDatabase sqLiteDatabase = new SqliteDBHelper(getApplicationContext()).getWritableDatabase();
                ContentValues cv = new ContentValues();
                EditText editTextLatitude = (EditText)findViewById(R.id.etlatitude);
                EditText editTextLongitude = (EditText)findViewById(R.id.etlongetude);
                cv.put("Latitude",editTextLatitude.getText().toString());
                cv.put("Longitude", editTextLongitude.getText().toString());
                sqLiteDatabase.insert("TblCoordenadas", null, cv);

                Toast.makeText(getApplicationContext(), "Salvo com sucesso", Toast.LENGTH_SHORT).show();*/

                /*salvarNoBanco(v);
            }
        });

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor = (Cursor) adapterView.getItemAtPosition(i);
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                String latitude = cursor.getString(cursor.getColumnIndexOrThrow("latitude"));
                String longitude = cursor.getString(cursor.getColumnIndexOrThrow("longitude"));

                Toast.makeText(getApplicationContext(), "Voce clicou em Id = : " + id, Toast.LENGTH_LONG).show();
                new DBLatitudeLongitude(MainActivity.this).deletar(id + "");
                MainActivity.this.atualizaListView();
            }
        });
        this.atualizaListView();
    }*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity", "#######################################################");
        Log.i("MainActivity", "protected void onCreate(Bundle savedInstanceState) {...");
        setContentView(R.layout.activity_main);
        setupElements();

        Button btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActivityLatitudeLongitudeListView.class);
                startActivity(i);

            }
        });


        final Bundle extras1 = getIntent().getExtras();
        Button btnSalvaCoords = (Button) findViewById(R.id.btnsalvar);


        if((null != extras1) && (extras1.get("id") != null)){
            Log.i("MainActivity", "onCreate: extras1.toString() =" +extras1.toString());
            Log.i("MainActivity", "onCreate: extras1.toString() =" +extras1.toString());
            Log.i("MainActivity", "onCreate: extras1.toString() =" +extras1.toString());

            this.listViewItemDTO = new ListViewItemDTO();
            this.listViewItemDTO.id = (int)extras1.get("id");
            this.listViewItemDTO.latitude = extras1.get("latitude").toString();
            this.listViewItemDTO.longitude = extras1.get("longitude").toString();

            EditText editTextLatitude = (EditText) findViewById(R.id.etlatitude);
            EditText editTextLongitude = (EditText) findViewById(R.id.etlongetude);

            editTextLatitude.setText(this.listViewItemDTO.latitude);
            editTextLongitude.setText(this.listViewItemDTO.longitude);


            btnSalvaCoords.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("MainActivity", "btnSalvaCoords...!!!EDITANDO!!! COORDENADAS");
                    if(MainActivity.this.listViewItemDTO != null) {
                        SQLiteDatabase sqliteDatabase = new SqliteDBHelper(getApplicationContext()).getWritableDatabase();
                        ContentValues cv = new ContentValues();
                        EditText editTextLatitude = (EditText) findViewById(R.id.etlatitude);
                        EditText editTextLongitude = (EditText) findViewById(R.id.etlongetude);
                        cv.put("latitude", editTextLatitude.getText().toString());
                        cv.put("longitude", editTextLongitude.getText().toString());
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
                    EditText editTextLatitude = (EditText) findViewById(R.id.etlatitude);
                    EditText editTextLongitude = (EditText) findViewById(R.id.etlongetude);
                    cv.put("latitude", editTextLatitude.getText().toString());
                    cv.put("longitude", editTextLongitude.getText().toString());
                    sqliteDatabase.insert("TblCoordenadas", null, cv);

                }
            });


        }
    }


    /*public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


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
    */

    /*public void salvarNoBanco(View view){
        Log.i("MainActivity", "public salvarNoBanco(View view{...");
        EditText textViewLatitude = (EditText)findViewById(R.id.etlatitude);
        EditText textViewLongitude = (EditText)findViewById(R.id.etlongetude);

        long i = new SqliteDBHelper(this).inserir(
                textViewLatitude.getText().toString(),
                textViewLongitude.getText().toString());*/
        /*this.atualizaListView();*/
        /*Log.i("MainActivity", "Lines affected" + i);
    }*/

    public void obterLatitudeELongitude(View view){
        Log.i("MainActivity", "public obterLatitudeELongitude(View view){..");
    }

    /*public void atualizaListView(){
        Log.i("MainActivity","public void atualizaListView(){...");
        Cursor c = new DBLatitudeLongitude(this).listarTudo();
        ListView lv = (ListView)findViewById(R.id.listViewLatitudeLongitude);
        ListViewCursorAdapter lca = new ListViewCursorAdapter(this, c);
        lv.setAdapter(lca);
    }*/

    public void setupElements(){
        etlati = (EditText) findViewById(R.id.etlatitude);
        etlonge = (EditText) findViewById(R.id.etlongetude);
        btnlocal = (Button) findViewById(R.id.btnobter);
        btnlocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGPS();
            }
        });
    }
    public void startGPS(){
        LocationManager lmaneger = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener lListener = new LocationListener(){
            public void onLocationChanged(Location locat){
                updateView(locat);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        lmaneger.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lListener);
    }
    public void updateView(Location locat){
        Double latitude = locat.getLatitude();
        Double longitude = locat.getLongitude();

        etlati.setText(latitude.toString());
        etlonge.setText(longitude.toString());
    }
}
