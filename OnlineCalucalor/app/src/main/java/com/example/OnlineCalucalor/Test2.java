package com.example.OnlineCalucalor;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test2 extends Activity {

    EditText Ed;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);
        btn = (Button) findViewById(R.id.prod);
        Ed = (EditText) findViewById(R.id.ED2);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onProdClick(View v){

        Double rez = null;
        boolean proshol = true;
        String info2;
        String info1 = "";

        info2 = ("<5000 шагов в день – «сидячая работа»; \n" +
                "7500-9999 шагов в день – «несколько активная работа»; \n" +
                "10-12 тыс. шагов – «активный образ жизни»; \n" +
                "свыше 12,5 тыс. шагов – «очень активный образ жизни»\n");
try {
    if (Ed.getText().length() > 0) {
        try {
            rez = Double.parseDouble(Ed.getText().toString()) / 365;
        } catch (Exception e) {
            proshol = false;
        }
        if ( Double.parseDouble(Ed.getText().toString()) > 30000 || Double.parseDouble(Ed.getText().toString()) < 500 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }
        if (Double.parseDouble(Ed.getText().toString()) > 0) {

        } else
            proshol = false;

        if (Double.isInfinite(rez))
            proshol = false;
        if (proshol == true) {
            if (rez < 5000) {
                info1 = ("Сидячая работа");
            }
            if (rez >= 7500 && rez < 9999) {
                info1 = ("Несколько активная работа");
            }
            if (rez >= 10000 && rez <= 12499) {
                info1 = ("Активный образ жизни");
            }
            if (rez > 12500) {
                info1 = ("Очень активный образ жизни");
            }


            Intent intent = new Intent(this, ResultsOfTest.class);

            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = myPreferences.edit();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.now();
            String date = String.valueOf(formatter.format(dateTime));

            editor.putString("itog2", "Уровень двигательной активности" + "\nВаш резульат: " + rez + "\n" + "Описание: " + info1 + "\n" + date);
            editor.commit();

            intent.putExtra("Res", rez);
            intent.putExtra("Inf2", info2);
            intent.putExtra("Inf1", info1);
            intent.putExtra("shet", 2);
            startActivity(intent);
        } else
            Toast.makeText(getApplicationContext(), "Заполните поля верно", Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(getApplicationContext(), "Вы заполнили не все поля", Toast.LENGTH_SHORT).show();
    }
}
catch(Exception e){}
    }
}
