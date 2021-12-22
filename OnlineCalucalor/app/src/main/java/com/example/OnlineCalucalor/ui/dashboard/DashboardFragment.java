package com.example.OnlineCalucalor.ui.dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.OnlineCalucalor.Test2;
import com.example.OnlineCalucalor.Test4;
import com.example.OnlineCalucalor.Test5;
import com.example.OnlineCalucalor.R;
import com.example.OnlineCalucalor.Test1;
import com.example.OnlineCalucalor.Test3;
import com.example.OnlineCalucalor.Test6;
import com.example.OnlineCalucalor.Test7;
import com.example.OnlineCalucalor.Test8;
import com.example.OnlineCalucalor.databinding.FragmentDashboardBinding;

import java.io.IOException;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    EditText editText;
    Intent intent; //Переменная Intent для возможности нескольких использований

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        editText = root.findViewById(R.id.ED1);

        SharedPreferences sPref =
                PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        SharedPreferences.Editor editor = sPref.edit();

        String voz1 = sPref.getString("voz", "");
        editText.setText(voz1);

        Button button1 = root.findViewById(R.id.btn1);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Double voz = null;
                        Boolean proshol = true;
                        try{
                             voz = Double.parseDouble(editText.getText().toString());
                        }
                       catch (Exception e) {

                          proshol = false;

                       }
                        if(proshol == true) {
                            if (editText.getText().length() != 0 && voz >= 16 && voz <= 100) {

                                editor.putString("voz", editText.getText().toString());
                                editor.commit();

                                Intent intent = new Intent(getContext(), Test1.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
                    }
                });

        Button button2 = root.findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double voz = null;
                Boolean proshol = true;
                try{
                    voz = Double.parseDouble(editText.getText().toString());
                }
                catch (Exception e) {

                    proshol = false;

                }
                if(proshol == true) {
                    if (editText.getText().length() != 0 && voz >= 16  && voz <= 100) {

                        editor.putString("voz", editText.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(getContext(), Test2.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
            }
        });

        Button button3 = root.findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double voz = null;
                Boolean proshol = true;
                try{
                    voz = Double.parseDouble(editText.getText().toString());
                }
                catch (Exception e) {

                    proshol = false;

                }
                if(proshol == true) {
                    if (editText.getText().length() != 0 && voz >= 16  && voz <= 100) {

                        editor.putString("voz", editText.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(getContext(), Test3.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
            }
        });

        Button button4 = root.findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double voz = null;
                Boolean proshol = true;
                try{
                    voz = Double.parseDouble(editText.getText().toString());
                }
                catch (Exception e) {

                    proshol = false;

                }
                if(proshol == true) {
                    if (editText.getText().length() != 0 && voz >= 16  && voz <= 100) {

                        editor.putString("voz", editText.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(getContext(), Test4.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
            }
        });

        Button button5 = root.findViewById(R.id.btn5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double voz = null;
                Boolean proshol = true;
                try{
                    voz = Double.parseDouble(editText.getText().toString());
                }
                catch (Exception e) {

                    proshol = false;

                }
                if(proshol == true) {
                    if (editText.getText().length() != 0 && voz >= 16  && voz <= 100) {

                        editor.putString("voz", editText.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(getContext(), Test5.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
            }
        });

        Button button6 = root.findViewById(R.id.btn6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double voz = null;
                Boolean proshol = true;
                try{
                    voz = Double.parseDouble(editText.getText().toString());
                }
                catch (Exception e) {

                    proshol = false;

                }
                if(proshol == true) {
                    if (editText.getText().length() != 0 && voz >= 16  && voz <= 100) {

                        editor.putString("voz", editText.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(getContext(), Test6.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
            }
        });

        Button button7 = root.findViewById(R.id.btn7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double voz = null;
                Boolean proshol = true;
                try{
                    voz = Double.parseDouble(editText.getText().toString());
                }
                catch (Exception e) {

                    proshol = false;

                }
                if(proshol == true) {
                    if (editText.getText().length() != 0 && voz >= 16  && voz <= 100) {

                        editor.putString("voz", editText.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(getContext(), Test7.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
            }
        });

        Button button8 = root.findViewById(R.id.btn8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double voz = null;
                Boolean proshol = true;
                try{
                    voz = Double.parseDouble(editText.getText().toString());
                }
                catch (Exception e) {

                    proshol = false;

                }
                if(proshol == true) {
                    if (editText.getText().length() != 0 && voz >= 16  && voz <= 100) {

                        editor.putString("voz", editText.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(getContext(), Test8.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
            }
        });

        Button allTests = root.findViewById(R.id.allTests);
        allTests.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Double voz = null;
                        Boolean proshol = true;
                        try{
                            voz = Double.parseDouble(editText.getText().toString());
                        }
                        catch (Exception e) {

                            proshol = false;

                        }
                        if(proshol == true) {
                            if (editText.getText().length() != 0 && voz >= 16  && voz <= 100) {

                                editor.putString("voz", editText.getText().toString());
                                editor.commit();

                                Intent intent = new Intent(getContext(), Test1.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), "Введите возраст правильно",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getActivity().getApplicationContext(), "Введите возраст нормально", Toast.LENGTH_SHORT).show();
                    }
                });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onClick(View view) {
        Intent intent = new Intent(getContext(), Test1.class);
        startActivity(intent);
    }
}