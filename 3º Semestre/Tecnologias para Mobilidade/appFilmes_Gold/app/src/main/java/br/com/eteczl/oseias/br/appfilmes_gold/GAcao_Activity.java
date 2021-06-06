package br.com.eteczl.oseias.br.appfilmes_gold;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GAcao_Activity extends AppCompatActivity {

    public static final String EXTRA_NOME_FILME =
            "br.com.eteczl.oseias.br.appfilmes_gold.EXTRA_NOME_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacao);
    }

    ImageView img1 = (ImageView) findViewById(R.id.img);
    TextView txtT = (TextView) findViewById(R.id.txtT);
    TextView txtS = (TextView) findViewById(R.id.txtT);
    Intent intent = getIntent();
    if (intent.hasExtra(EXTRA_NOME_FILME)) {

    }
        //Acao
        if (intent.getStringExtra(EXTRA_NOME_FILME).equals(getResources().getString(R.string.txtFilme1))) {
            img1.setImageResource(R.drawable.acaofilme1);
            txtT.setText(R.string.filme1_acao);
            txtS.setText(R.string.tacao1);
        }
        if (intent.getStringExtra(EXTRA_NOME_FILME).equals(getResources().getString(R.string.filme2_acao))) {
            img1.setImageResource(R.drawable.m2_acao);
            txtT.setText(R.string.filme2_acao);
            txtS.setText(R.string.m2_acao);
        }
        if (intent.getStringExtra(EXTRA_NOME_FILME).equals(getResources().getString(R.string.filme3_acao))) {
            img1.setImageResource(R.drawable.m3_acao);
            txtT.setText(R.string.filme3_acao);
            txtS.setText(R.string.m3_acao);
        }
        if (intent.getStringExtra(EXTRA_NOME_FILME).equals(getResources().getString(R.string.filme4_acao))) {
            img1.setImageResource(R.drawable.m4_acao);
            txtT.setText(R.string.filme4_acao);
            txtS.setText(R.string.m4_acao);
        }
        if (intent.getStringExtra(EXTRA_NOME_FILME).equals(getResources().getString(R.string.filme5_acao))) {
            img1.setImageResource(R.drawable.m5_acao);
            txtT.setText(R.string.filme5_acao);
            txtS.setText(R.string.m5_acao);
        }
        if (intent.getStringExtra(EXTRA_NOME_FILME).equals(getResources().getString(R.string.filme6_acao))) {
            img1.setImageResource(R.drawable.m6_acao);
            txtT.setText(R.string.filme6_acao);
            txtS.setText(R.string.m6_acao);
        }
}
