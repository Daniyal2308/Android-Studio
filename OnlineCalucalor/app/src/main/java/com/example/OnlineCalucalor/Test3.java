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

public class Test3 extends Activity {

    EditText shss;
    EditText cad;
    EditText dad;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3);

        shss = (EditText) findViewById(R.id.SHSS);
        cad = (EditText) findViewById(R.id.CAD);
        dad = (EditText) findViewById(R.id.DAD);
        btn = (Button) findViewById(R.id.prod);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onProdClick(View v){

        Double rez = null;
        boolean proshol = true;
        String info2;
        String info1 = "";

        info2 = ("В норме коэффициент выносливости – 16 усл. ед., \n" +
                "- уменьшение – на усиление кардиореспираторной системы. \n" +
                "- увеличение указывает на ослабление деятельности сердечно-сосудистой системы или детренированности обследуемого\n" +
                "- при занятиях спортом коэффициент выносливости может быть ниже 16 усл.ед., из-за укрепления сердечно-сосудистой системы, коэффициент выносливости коррелирует с уровнем физической работоспособности организма\n" +
                "- пульсовое давление ПД (САД-ДАД) в среднем составляет 40 мм рт.ст.\n" +
                "- функционирование сердечно-сосудистой системы можно представить\n" +
                "как причинно-следственный процесс причиной (входом) которого является\n" +
                "систолическое АД (САД), а следствием (выходом) – диастолическое АД (ДАД), зависимость выхода от входа опосредуется через пульсовое давление ПД= САД – ДАД\n" +
                "- ПД (пульсовое давление) является переходной функцией (оператором)\n" +
                "нейрогуморальной регуляции кровообращения.\n" +
                "- для улучшения коэффициента выносливости сердечно-сосудистой системы следует заниматься ФКиС не менее трех раз в неделю, совершать 10-12,5 тысяч шагов в сутки\n");
try {
    if (shss.getText().length() > 0 && cad.getText().length() > 0 && dad.getText().length() > 0) {

        if ( Double.parseDouble(shss.getText().toString()) > 200 || Double.parseDouble(shss.getText().toString()) < 50 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }
        if ( Double.parseDouble(cad.getText().toString()) > 200 || Double.parseDouble(cad.getText().toString()) < 50 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }
        if ( Double.parseDouble(dad.getText().toString()) > 200 || Double.parseDouble(dad.getText().toString()) < 50 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }
        try {
            rez = Double.parseDouble(shss.getText().toString()) / (Double.parseDouble(cad.getText().toString()) - Double.parseDouble(dad.getText().toString()));
        } catch (Exception e) {
            proshol = false;
        }
        if (Double.parseDouble(shss.getText().toString()) > 0 && Double.parseDouble(cad.getText().toString()) > 0 && Double.parseDouble(dad.getText().toString()) > 0) {

        } else
            proshol = false;

        if (Double.isInfinite(rez) == true)
            proshol = false;

        if (proshol == true) {
            if (rez < 16) {
                info1 = ("Усиление кардиореспираторной системы\n");
            }
            if (rez >= 7500 && rez < 9999) {
                info1 = ("Укрепленная сердечно-сосудистая система");
            }

            Intent intent = new Intent(this, ResultsOfTest.class);

            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = myPreferences.edit();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.now();
            String date = String.valueOf(formatter.format(dateTime));

            editor.putString("itog3", "Коэфициент выносливости" + "\nВаш резульат: " + rez + "\n" + "Описание: " + info1 + "\n" + date);
            editor.commit();

            intent.putExtra("Res", rez);
            intent.putExtra("Inf2", info2);
            intent.putExtra("Inf1", info1);
            intent.putExtra("shet", 3);
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
