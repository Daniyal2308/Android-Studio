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

public class Test4 extends Activity {

    Button btn;
    EditText shss;
    EditText cad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test4);

        btn = (Button) findViewById(R.id.prod);
        shss = (EditText) findViewById(R.id.SHSS);
        cad = (EditText) findViewById(R.id.CAD);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onProdClick(View v) {
        boolean proshol = true;
        String info1 = "18";
        String info2;
        Double rez = null;
        try {
            if (cad.getText().length() != 0 || shss.getText().length() != 0) {
                try {
                    rez = (Double.parseDouble(shss.getText().toString()) * Double.parseDouble(cad.getText().toString())) / 100;
                } catch (Exception e) {
                    proshol = false;
                }
                if ( Double.parseDouble(shss.getText().toString()) > 200 || Double.parseDouble(shss.getText().toString()) < 50 ) {
                    Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }
                if ( Double.parseDouble(cad.getText().toString()) > 200 || Double.parseDouble(cad.getText().toString()) < 50 ) {
                    Toast.makeText(getApplicationContext(), "не допустиме значения", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }
                if (Double.parseDouble(shss.getText().toString()) > 0 && Double.parseDouble(cad.getText().toString()) > 0) {

                } else
                    proshol = false;

                if (Double.isInfinite(rez))
                    proshol = false;
                if (proshol == true) {
                    if (rez < 74) info1 = "Высокий уровень регуляции сердечно-сосудистой системы";
                    if (rez > 74 && rez < 81) info1 = "Выше среднего";
                    if (rez > 81 && rez < 91) info1 = "Средний";
                    if (rez > 90 && rez < 101) info1 = "Ниже среднего";
                    if (rez >= 101) info1 = "низкое значение регуляции";

                    info2 = "до 74 усл. ед. – высокий уровень регуляции сердечно-сосудистой системы; \n" + "75-80 – выше среднего; \n" +
                            "81-90 – средний; \n" +
                            "91-100 – ниже среднего; \n" +
                            "101 и выше – низкое значение регуляции. \n" +
                            "- показатели регуляции сердечно-сосудистой системы у спортсменов ниже, чем у  нетренированных лиц, так как сердце спортсмена в условиях покоя работает в более экономичном  режиме, при меньшем потреблении кислорода.\n" +
                            "индекс используется для косвенного определения степени обеспеченности миокарда  кислородом\n" +
                            "- результаты индекса на студентах РЭУ им. Г.В. Плеханова: \n" + "девушки 90-101 усл. ед., юноши 92,3-96 усл. ед\n" +
                            "- в процессе регулярных занятий ФКиС значения индекса постепенно снижаются, и могут  достигать среднего, выше среднего и высокого уровня регуляции сердечно-сосудистой системы\n";

                    Intent intent = new Intent(this, ResultsOfTest.class);

                    SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = myPreferences.edit();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime dateTime = LocalDateTime.now();
                    String date = String.valueOf(formatter.format(dateTime));

                    editor.putString("itog4", "Уровень регуляции сердечно-сосудистой системы" + "\nВаш резульат: " + rez + "\n" + "Описание: " + info1 + "\n" + date);
                    editor.commit();

                    intent.putExtra("Res", rez);
                    intent.putExtra("Inf2", info2);
                    intent.putExtra("Inf1", info1);
                    intent.putExtra("shet", 4);
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
