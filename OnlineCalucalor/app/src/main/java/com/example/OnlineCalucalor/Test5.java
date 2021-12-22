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

public class Test5 extends Activity {

    Button btn;
    EditText gel;
    EditText m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test5);

        btn = findViewById(R.id.prod);
        gel = findViewById(R.id.GEL);
        m = findViewById(R.id.M);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onProdClick(View v) {
        boolean proshol = true;
        Double itog = null;
        String info1 = "18";
        String info2;
        try {
            if (m.getText().length() != 0 || gel.getText().length() != 0) {
                try {
                    itog = Double.parseDouble(gel.getText().toString()) / Double.parseDouble(m.getText().toString());
                } catch (Exception e) {
                    proshol = false;
                }
                if ( Double.parseDouble(gel.getText().toString()) > 5000 || Double.parseDouble(gel.getText().toString()) < 0 ) {
                    Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }
                if ( Double.parseDouble(m.getText().toString()) > 250 || Double.parseDouble(m.getText().toString()) < 40 ) {
                    Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }
                if (Double.parseDouble(gel.getText().toString()) > 0 && Double.parseDouble(m.getText().toString()) > 0) {

                } else
                    proshol = false;

                if (Double.isInfinite(itog))
                    proshol = false;
                if (proshol == true) {
                    if (itog <= 61 && itog >= 50) info1 = "норма";
                    if (itog > 61) info1 = "выше нормы";
                    if (itog < 50) info1 = "ниже нормы";
                    info2 = "- норма 50-61 мл/кг; если показатель меньше, то это может свидетельствовать о  недостаточности кислород обеспечения организма, недостаточной жизненной емкости легких, либо  избыточной массе тела \n" +
                            "- для обследуемых, имеющих жизненный индекс ниже нормы рекомендуются физические  упражнения средней интенсивности, наряду с этим допускается чередование высокоинтенсивных  (молодой и средний возраст) и малоинтенсивных тренировочных нагрузок.\n" + "- на увеличение жизненной емкости легких влияют регулярные занятия физической  культурой и спортом, особенно занятия аэробной направленности (бег, велопрогулки, плавание,  аэробика, работа на кардиотренажерах, спортивные игры и другие).\n" +
                            "-при большой жизненной емкости (ЖЕЛ) легкие лучше вентилируются и организм получает  больше кислорода. Норма ЖЕЛ у мужчин 3500-5000 мл, у женщин 2500-4000 мл. В исследовании РЭУ  им. Г.В. Плеханова ЖЕЖ у девушек 2100-2600 мл, у юношей 3800-4150 мл.\n" + "-у лиц, не занимающихся физической культурой и спортом чаще всего, жизненная емкость  легких ниже по сравнению с лицами регулярно занимающимися ФКиС\n" +
                            "- жизненный индекс на 10-12% ниже у лиц имеющих избыточную массу тела\n";

                    Intent intent = new Intent(this, ResultsOfTest.class);

                    SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = myPreferences.edit();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime dateTime = LocalDateTime.now();
                    String date = String.valueOf(formatter.format(dateTime));

                    editor.putString("itog5", "Жизненный индекс" + "\nВаш резульат: " + itog + "\n" + "Описание: " + info1 + "\n" + date);
                    editor.commit();

                    intent.putExtra("Res", itog);
                    intent.putExtra("Inf2", info2);
                    intent.putExtra("Inf1", info1);
                    intent.putExtra("shet", 5);
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
