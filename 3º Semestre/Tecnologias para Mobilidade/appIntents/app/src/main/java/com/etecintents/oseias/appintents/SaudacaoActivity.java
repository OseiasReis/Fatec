package com.etecintents.oseias.appintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SaudacaoActivity extends AppCompatActivity {

    public static final String EXTRA_NOME_USUARIO = "saudacao.EXTRA_NOME_USUARIO";

    public static final String ACAO_EXIBIR_SAUDACAO = "saudacao.ACAO_EXIBIR_SAUDACAO";

    public static final String CATEGORIA_SAUDACAO = "saudacao.CATEGORIA_SAUDACAO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saudacao);

        TextView saudacaoTextView =
                (TextView) findViewById(R.id.saudacaoTextView);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_NOME_USUARIO)) {
            String saudacao = getResources().getString(R.string.title_activity_saudacao);
            saudacaoTextView.setText(saudacao + " " +
                    intent.getStringExtra(EXTRA_NOME_USUARIO));
        } else {
            saudacaoTextView.setText("O nome do usuário não foi informado");
        }
    }
}
