package br.com.eteczl.appsql;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etLat;
    private EditText etLon;
    private Button bLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupElements();
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

        Button btnSalvarCoords = (Button) findViewById(R.id.btnsalvar);
        btnSalvarCoords.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.i("MainActivity", "btnSalvarCoords...Salvando COORDENADAS");
                SQLiteDatabase sqLiteDatabase = new SqliteDBHelper(getApplicationContext()).getWritableDatabase();
                ContentValues cv = new ContentValues();
                EditText editTextLatitude = (EditText) findViewById(R.id.editTextlatitude);
                EditText editTextLongitude = (EditText) findViewById(R.id.editTextlogitude);
                cv.put("Latitude", editTextLatitude.getText().toString());
                cv.put("Longitude", editTextLongitude.getText().toString());
                sqLiteDatabase.insert("TblCoordenadas", null, cv);

                Toast.makeText(getApplicationContext(), "Salvando", Toast.LENGTH_LONG).show();
            }
        });
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




    public void setupElements() {
        etLat = (EditText) findViewById(R.id.editTextlatitude);
        etLon = (EditText) findViewById(R.id.editTextlogitude);

        bLoc = (Button) findViewById(R.id.btnLoc);
        bLoc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startGPS();
            }
        });

    }

    public void startGPS() {
        LocationManager lManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener lListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location locat) {
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
        lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lListener);
    }

    public void updateView(Location locat){
        Double latitude = locat.getLatitude();
        Double longitude = locat.getLongitude();

        etLat.setText(latitude.toString());
        etLon.setText(longitude.toString());
    }

}