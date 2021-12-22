package com.example.OnlineCalucalor.ui.notifications;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.OnlineCalucalor.R;
import com.example.OnlineCalucalor.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;


public class NotificationsFragment extends Fragment {


    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        ListView listView = binding.listitem;

        SharedPreferences myPreferences =
                PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        SharedPreferences.Editor editor = myPreferences.edit();

        ArrayList<String> ar = new ArrayList<String>();
        ar.add("Индекс массы тела\n"+myPreferences.getString("itog1","-"));
//        ar.add("Индекс функциональных изменений\n"+myPreferences.getString("itog2","-"));
//        ar.add("Циркулярно-респираторный коэффициент Скибински\n"+myPreferences.getString("itog3","-"));
//        ar.add("Коэффициент выносливости\n"+myPreferences.getString("itog4","-"));
//        ar.add("Уровень двигательный активности\n"+myPreferences.getString("itog5","-"));
//        ar.add("Уровень регуляции сердечно-сосудистой системы\n"+myPreferences.getString("itog6","-"));
//        ar.add("Вегетативный индекс Кердо\n"+myPreferences.getString("itog7","-"));
//        ar.add("Жизненный индекс\n"+myPreferences.getString("itog8","-"));


        ArrayAdapter arrayAdapter =
                new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1);

        listView.setAdapter(arrayAdapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}