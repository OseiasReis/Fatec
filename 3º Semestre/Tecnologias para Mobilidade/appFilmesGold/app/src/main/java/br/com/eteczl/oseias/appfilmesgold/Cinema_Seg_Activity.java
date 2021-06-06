package br.com.eteczl.oseias.appfilmesgold;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class Cinema_Seg_Activity extends AppCompatActivity {

    //private static ImageView img1, img2, img3,  img4,  img5, img6, img7, img8;
    //public TextView Filme1, Filme2, Filme3, Filme4, Filme5, Filme6, Filme7, Filme8;
    //private static Button btnAA, btnAni, btnCom, btnTer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema__seg_);

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
