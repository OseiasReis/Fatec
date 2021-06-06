package br.com.eteczl.oseias.appfilmesgold;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Inicial_Activity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_inicial);
        }

        public void ClickInic(View view) {
            //Ao clickar no Button ele vai pra seg tela
            Intent intent = new Intent(this, Cinema_Seg_Activity.class);
            startActivity(intent);
        }

        public void ClickInfo(View view) {
            AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Informações");
            alertDialog.setMessage("Versão 1.0 - 04/04/2016\n\n © 2016-2016  Oséias P. Reis \n Todos os direitos reservados.");
            alertDialog.show();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_inicial_, menu);
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
}
