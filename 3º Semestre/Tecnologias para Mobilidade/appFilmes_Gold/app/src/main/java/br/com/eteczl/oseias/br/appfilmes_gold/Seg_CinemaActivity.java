package br.com.eteczl.oseias.br.appfilmes_gold;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Seg_CinemaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seg__cinema);
        //Intent intent = new Intent(this, GAcao_Activity.class);
        //startActivity(intent);

    }

    public void Acao(View view){
        Intent intent = new Intent(this, GAcao_Activity.class);
        startActivity(intent);
    }

    public void Anime(View view){
        Intent intent = new Intent(this, GAnime_Activity.class);
        startActivity(intent);
    }

    public void Comedia(View view){
        Intent intent = new Intent(this, GComedia_Activity.class);
        startActivity(intent);
    }

    public void Terror(View view){
        Intent intent = new Intent(this, GTerror_Activity.class);
        startActivity(intent);
    }

    public void ClickVoltar (View view){
        finish();
    }
}
