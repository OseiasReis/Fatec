package com.consulta.oseias.appconsulta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
    }
    public void salvar(View view){
        if(validaFormulario())
        Toast.makeText(this,"Form Validado",Toast.LENGTH_LONG).show();
        return;
    }

    private boolean validaFormulario(){
        EditText txtProfissional = (EditText) findViewById(R.id.txt_prof);
        EditText txtDataDaConsulta = (EditText) findViewById(R.id.txt_datacon);
        EditText txtHoraDaConsulta = (EditText) findViewById(R.id.txt_horacon);

        if(txtProfissional.getText().toString().length() == 0){
            Toast.makeText(this,"Faltou Profissional",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtDataDaConsulta.getText().toString().length() == 0){
            Toast.makeText(this,"Faltou Data Da Consulta",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtHoraDaConsulta.getText().toString().length() == 0){
            Toast.makeText(this,"Faltou Hora Da Consulta",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
