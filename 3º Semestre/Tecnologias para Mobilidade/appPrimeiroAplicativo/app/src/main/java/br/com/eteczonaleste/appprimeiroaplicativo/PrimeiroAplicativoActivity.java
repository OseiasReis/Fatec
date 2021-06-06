package br.com.eteczonaleste.appprimeiroaplicativo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class PrimeiroAplicativoActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText edtNumero1;
    private EditText edtNumero2;
    private EditText edtMedia;

    private double num1,num2,media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeiro_aplicativo);


        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2);
        edtMedia = (EditText) findViewById(R.id.edtMedia);

        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                num1 = Double.parseDouble(edtNumero1.getText().toString());
                num2 = Double.parseDouble(edtNumero2.getText().toString());

                media = (num1 + num2) /2;

                try{
                    edtMedia.setText(String.valueOf(media));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


    }
}
