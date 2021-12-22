package com.example.OnlineCalucalor;

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
import androidx.appcompat.app.AppCompatActivity;

import com.example.OnlineCalucalor.databinding.ActivityMainBinding;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test1 extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysettings";

    public static final String APP_PREFERENCES_REZ1 = "Nickname";

    Button btn;
    EditText mas;
    EditText rost;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);




    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onProdClick(View v) {
        btn = findViewById(R.id.prod);
        mas = findViewById(R.id.ED2);
        rost = findViewById(R.id.ED1);

        String info1 = "18";
        String info2;
        Double rez = null;
        boolean proshol = true;
        try {
            if (rost.getText().length() != 0 || mas.getText().length() != 0) {
                try {
                    rez = Double.parseDouble(mas.getText().toString()) / Math.pow(Double.parseDouble(rost.getText().toString()), 2);
                } catch (Exception e) {
                    proshol = false;
                }
                if (Double.parseDouble(mas.getText().toString()) > 0 && Math.pow(Double.parseDouble(rost.getText().toString()), 2) > 0) {

                } else {
                    proshol = false;
                }
                if (Double.isInfinite(rez))
                    proshol = false;
                if ( Double.parseDouble(mas.getText().toString()) > 250 || Double.parseDouble(mas.getText().toString()) < 40 ) {
                    Toast.makeText(getApplicationContext(), "введите корректный вес", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }
                if ( Double.parseDouble(rost.getText().toString()) > 2 || Double.parseDouble(rost.getText().toString()) < 1 ) {
                    Toast.makeText(getApplicationContext(), "введите корректный рост", Toast.LENGTH_SHORT).show();
                    proshol = false;
                }
                if (proshol == true) {
                    if (rez < 18.5 && rez > 16 || rez < 16)
                        info1 = "Наблюдается недостаток массы тела";
                    if (rez < 25 && rez > 18.5) info1 = "Наблюдается нормальная масса тела";
                    if (rez < 30 && rez > 25) info1 = "Наблюдается избыточная масса тела";
                    if (rez < 35 && rez > 30) info1 = "Наблюдается первая степень ожирения";
                    if (rez < 40 && rez > 35) info1 = "Наблюдается вторая степень ожирения";
                    if (rez > 40) info1 = "Наблюдается третья степень ожирения";
                    info2 = "- 16-18,5 кг/м2 и менее, то наблюдается недостаток массы тела, \n" +
                            "- 18,5-25 кг/м2 – норма, \n" +
                            "25-30 кг/м2 – избыточная масса тела, \n" +
                            "30-35 кг/м2 – первая степень ожирения, \n" +
                            "35-40 кг/м2 – вторая степень ожирения, \n" +
                            "свыше 40 кг/м2 – третья степень ожирения.\n" +
                            "- индекс не учитывает пол, возраст, распределение в организме жирового и мышечного компонента тела\n" +
                            "- средние значения индекса, полученные в РЭУ им. Г.В. Плеханова составили у девушек – 19-23 кг/м2, у юношей 20-23 кг/м2\n" +
                            "- у представителей молодого возраста (до 30 лет) индекс массы тела ниже по сравнению с представителями среднего возраста\n" +
                            "- для поддержания оптимальной массы тела необходимо ходить не менее 10 тысяч шагов в сутки\n" +
                            "- по индексу массы тела можно лишь косвенно судить о норме, недостатке или избыточной массе тела\n" +
                            "- при индексе свыше 25 кг/м2 необходимо подключить онлайн-калькулятор питания и контролировать полученные калории, увеличить прогулки на свежем воздухе, ограничить хлебобулочные изделия";
                    Intent intent = new Intent(this, ResultsOfTest.class);

                    SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = myPreferences.edit();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime dateTime = LocalDateTime.now();
                    String date = String.valueOf(formatter.format(dateTime));

                    editor.putString("itog1", "Индекс массы тела" + "\nВаш резульат: " + rez + "\n" + "Описание: " + info1 + "\n" + date);
                    editor.commit();

                    intent.putExtra("Res", rez);
                    intent.putExtra("Inf2", info2);
                    intent.putExtra("Inf1", info1);
                    intent.putExtra("shet", 1);
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