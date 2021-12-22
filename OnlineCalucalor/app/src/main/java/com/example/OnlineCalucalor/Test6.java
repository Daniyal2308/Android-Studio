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
public class Test6 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test6);

        shss = (EditText) findViewById(R.id.SHSS);
        ph = (EditText) findViewById(R.id.PH);
        gel = (EditText) findViewById(R.id.GEL);
        btn = (Button) findViewById(R.id.prod);
    }

    EditText gel;
    EditText ph;
    EditText shss;
    Button btn;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onProdClick(View view) {
        boolean proshol = true;
        Double itog = null;
        String info1 = "18";
        String info2;
        try {
            if (shss.getText().toString().length() != 0 && ph.getText().toString().length() != 0 && gel.getText().toString().length() != 0) {
                try {
                    itog = (Double.parseDouble(shss.getText().toString()) / 100) *
                            Double.parseDouble(ph.getText().toString()) / Double.parseDouble(gel.getText().toString());
                } catch (Exception e) {
                    proshol = false;
                }
                if (Double.parseDouble(shss.getText().toString()) > 0 && Double.parseDouble(ph.getText().toString()) > 0 && Double.parseDouble(gel.getText().toString()) > 0) {

                } else
                    proshol = false;
                if ( Double.parseDouble(gel.getText().toString()) > 5000 || Double.parseDouble(gel.getText().toString()) < 0 ) {
                    Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }
                if ( Double.parseDouble(shss.getText().toString()) > 200 || Double.parseDouble(shss.getText().toString()) < 50 ) {
                    Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }
                if ( Double.parseDouble(ph.getText().toString()) > 10000 || Double.parseDouble(ph.getText().toString()) < 1 ) {
                    Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }

                if (Double.isInfinite(itog))
                    proshol = false;
                if (proshol == true) {
                    Intent intent = new Intent(this, ResultsOfTest.class);
                    if (itog <= 5) info1 = "очень плохо";
                    if (itog > 5 && itog <= 10) info1 = "неудовлетворительно";
                    if (itog > 10 && itog < 30) info1 = "удовлетворительно";
                    if (itog >= 30 && itog < 60) info1 = "хорошо";
                    if (itog >= 60) info1 = "очень хорошо";
                    info2 = "Оценка индекса: \n" +
                            "<5 усл. ед. – очень плохо (низкий уровень выносливость сердечно-сосудистой и  дыхательной систем), \n" +
                            "5-10 – неудовлетворительно, \n" +
                            "10-30 – удовлетворительно, \n" +
                            "30-60 – хорошо,\n" +
                            " > 60 – очень хорошо (высокий уровень выносливости). \n" +
                            "- проба Штанге (с), определяющая гипоксическую устойчивость организма (время  задержки дыхания на вдохе). \n" +
                            "- индекс Скибински характеризует состояние сердечно-сосудистой и дыхательной  систем.\n";
                    SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = myPreferences.edit();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime dateTime = LocalDateTime.now();
                    String date = String.valueOf(formatter.format(dateTime));
                    editor.putString("itog6", "Циркулярно-респираторный коэффициент Скибински" + "\nВаш резульат: " + itog + "\n" + "Описание: " + info1 + "\n" + date);
                    editor.commit();

                    intent.putExtra("Res", itog);
                    intent.putExtra("Inf2", info2);
                    intent.putExtra("Inf1", info1);
                    intent.putExtra("shet", 6);
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(), "Заполните поля верно", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(getApplicationContext(), "Вы заполнили не все поля", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){}
    }
}
