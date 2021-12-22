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

public class Test7 extends Activity {

    EditText dad;
    EditText shss;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test7);

        dad = (EditText) findViewById(R.id.DAD);
        shss = (EditText) findViewById(R.id.SHSS);
        btn = (Button) findViewById(R.id.prod);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onProdClick(View view) {

        String info1 = "18";
        String info2;
        Double itog = null;
        boolean proshol = true;
try {
    if (dad.getText().toString().length() != 0 && shss.getText().toString().length() != 0 && shss.getText().toString().length() != 0) {
        try {
            itog = 100 * (1 - (Double.parseDouble(dad.getText().toString())) / Double.parseDouble(shss.getText().toString()));
        } catch (Exception e) {
            proshol = false;
        }
        if (Double.parseDouble(dad.getText().toString()) > 0 && Double.parseDouble(shss.getText().toString()) > 0) {

        } else
            proshol = false;
        if ( Double.parseDouble(dad.getText().toString()) > 300 || Double.parseDouble(dad.getText().toString()) < 20 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }
        if ( Double.parseDouble(shss.getText().toString()) > 200 || Double.parseDouble(shss.getText().toString()) < 50 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }

        if (Double.isInfinite(itog))
            proshol = false;
        if (proshol == true) {
            Intent intent = new Intent(this, ResultsOfTest.class);
            if (itog >= 31) info1 = "выраженная симпатикотония";
            if (itog >= 16 && itog <= 30) info1 = "симпатикотония";
            if (itog >= -15 && itog <= 15)
                info1 = "уравновешенность симпатических и парасимпатических  влияний";
            if (itog >= -16 && itog < -30) info1 = "парасимпатикотония";
            if (itog <= -30) info1 = "парасимпатикотония";
            info2 = "Индекс Кердо в норме равен 0 усл. ед., что демонстрирует оптимальный уровень  вегетативной регуляции сердечно-сосудистой системы, \n" +
                    "- при преобладании симпатического тонуса отмечается увеличение, - при преобладании  парасимпатического тонуса отмечается снижение индекса";
            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = myPreferences.edit();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.now();
            String date = String.valueOf(formatter.format(dateTime));
            editor.putString("itog7", "Вегетативный индекс Кердо" + "\nВаш резульат: " + itog + "\n" + "Описание: " + info1 + "\n" + date);
            editor.commit();

            intent.putExtra("Res", itog);
            intent.putExtra("Inf2", info2);
            intent.putExtra("Inf1", info1);
            intent.putExtra("shet", 7);
            startActivity(intent);
        } else
            Toast.makeText(getApplicationContext(), "Заполните поля верно", Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
    }
}
catch(Exception e){}
    }
}

