package br.com.eteczl.oseias.appfilmesgold;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class GAcao_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacao_);

        //Cinema_Seg_Activity csa = new Cinema_Seg_Activity();

    }
}
