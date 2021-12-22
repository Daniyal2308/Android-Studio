package com.example.OnlineCalucalor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsOfTest extends Activity {

    TextView info;
    TextView rez;
    TextView opis;
    Button btn;

    int sh1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultsoftest);

        info = (TextView) findViewById(R.id.info);
        opis = (TextView) findViewById(R.id.Opis);
        rez = (TextView) findViewById(R.id.Rezult);
        btn = findViewById(R.id.prod);

        Bundle intent = getIntent().getExtras();

        String Info = intent.getString("Inf2");
        String Opisanie = intent.getString("Inf1");
        double Rez = intent.getDouble("Res");
        int sh = intent.getInt("shet");
        sh1 = sh;

        rez.setText("Ваш результат: " + Rez);
        opis.setText("Описание: \n " + Opisanie);
        info.setText(Info);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sh == 1){
                    startActivity(new Intent(ResultsOfTest.this, Test2.class));
                }
                if(sh == 2){
                    startActivity(new Intent(ResultsOfTest.this, Test3.class));
                }
                if(sh == 3){
                    startActivity(new Intent(ResultsOfTest.this, Test4.class));
                }
                if(sh == 4){
                    startActivity(new Intent(ResultsOfTest.this, Test5.class));
                }
                if(sh == 5){
                    startActivity(new Intent(ResultsOfTest.this, Test6.class));
                }
                if(sh == 6){
                    startActivity(new Intent(ResultsOfTest.this, Test7.class));
                }
                if(sh == 7){
                    startActivity(new Intent(ResultsOfTest.this, Test8.class));
                }
                if(sh1 == 8){
                    startActivity(new Intent(ResultsOfTest.this, MainActivity.class));
                }

            }
        });
    }

    public void onProdClick(View view) {

    }


}