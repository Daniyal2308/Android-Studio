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

public class Test8 extends Activity {

    EditText dad;
    EditText shss;
    EditText cad;
    EditText voz;
    EditText mas;
    EditText rost;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test8);



        dad = (EditText) findViewById(R.id.DAD);
        shss = (EditText) findViewById(R.id.SHSS);
        cad = (EditText) findViewById(R.id.CAD);
        voz = (EditText) findViewById(R.id.VOZ);
        mas = (EditText) findViewById(R.id.MAS);
        rost = (EditText) findViewById(R.id.ROST);
        btn = (Button) findViewById(R.id.prod);

        SharedPreferences sPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edito = sPref.edit();

        String s = sPref.getString("voz", " ");

        voz.setText(s);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onProdClick(View view) {



        boolean proshol = true;
        Double itog = null;
        String info1 = "18";
        String info2;
try {
    if (dad.getText().toString().length() != 0 && shss.getText().toString().length() != 0 && cad.getText().toString().length() != 0 && voz.getText().toString().length() != 0 && mas.getText().toString().length() != 0 && rost.getText().toString().length() != 0) {
        try {
            itog = 0.11 * Double.parseDouble(shss.getText().toString()) + 0.014 * Double.parseDouble(cad.getText().toString())
                    + 0.008 * Double.parseDouble(dad.getText().toString()) + 0.014 * Double.parseDouble(voz.getText().toString())
                    + 0.009 * Double.parseDouble(mas.getText().toString()) - 0.009 * Double.parseDouble(rost.getText().toString()) - 0.27;
        } catch (Exception e) {
            proshol = false;
        }
        if (Double.parseDouble(shss.getText().toString()) > 0 && Double.parseDouble(cad.getText().toString()) > 0 && Double.parseDouble(dad.getText().toString()) > 0 && Double.parseDouble(voz.getText().toString()) > 0
                && Double.parseDouble(mas.getText().toString()) > 0 && Double.parseDouble(rost.getText().toString()) > 0) {

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
        if ( Double.parseDouble(rost.getText().toString()) > 200 || Double.parseDouble(rost.getText().toString()) < 100 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }
        if ( Double.parseDouble(mas.getText().toString()) > 250 || Double.parseDouble(mas.getText().toString()) < 40 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }
        if ( Double.parseDouble(cad.getText().toString()) > 200 || Double.parseDouble(cad.getText().toString()) < 50 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }
        if ( Double.parseDouble(voz.getText().toString()) > 100 || Double.parseDouble(voz.getText().toString()) < 18 ) {
            Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
            proshol = false;
        }

        if (Double.isInfinite(itog))
            proshol = false;
        if (proshol == true) {
            Intent intent = new Intent(this, ResultsOfTest.class);
            if (itog < 2.6) info1 = "функциональные возможности системы кровообращения хорошие";
            if (itog >= 2.6 && itog <= 3.09)
                info1 = "удовлетворительные функциональные возможности системы кровообращения";
            if (itog > 3.09)
                info1 = "сниженные, недостаточные возможности системы кровообращения";

            info2 = "ИФИ менее 2,6 — функциональные возможности системы кровообращения хорошие. Механизмы адаптации устойчивы: действие неблагоприятных факторов студенческого образа жизни успешно компенсируется мобилизацией внутренних резервов организма, эмпирически подобранными профилактическими мероприятиями (увлечение спортом, рациональное распределение времени на работу и отдых, адекватная организация питания).\n" +
                    "ИФИ, равный 2,6—3,09 — удовлетворительные функциональные возможности системы кровообращения с умеренным напряжением механизмов регуляции. Эта категория практически здоровых людей, имеющих скрытые или нераспознанные заболевания, нуждающихся в дополнительном обследовании. Скрытые или неясно выраженные нарушения процессов адаптации могут быть восстановлены с помощью методов нелекарственной коррекции (массаж, мышечная релаксация, дыхательная гимнастика, аутотренинг), компенсирующих недостаточность или слабость внутреннего звена саморегуляции функций.\n" +
                    "ИФИ более 3,09 — сниженные, недостаточные возможности системы кровообращения, наличие выраженных нарушений процессов адаптации. Необходима полноценная диагностика, квалифицированное лечение и индивидуальный подбор профилактических мероприятий в период ремиссии.\n";

            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = myPreferences.edit();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.now();
            String date = String.valueOf(formatter.format(dateTime));
            editor.putString("itog8", "Индекс функциональных изменений" + "\nВаш резульат: " + itog + "\n" + "Описание: " + info1 + "\n" + date);
            editor.commit();

            intent.putExtra("Res", itog);
            intent.putExtra("Inf2", info2);
            intent.putExtra("Inf1", info1);
            intent.putExtra("shet", 8);
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

