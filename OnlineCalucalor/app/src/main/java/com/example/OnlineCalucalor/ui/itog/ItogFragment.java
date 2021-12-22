package com.example.OnlineCalucalor.ui.itog;

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
import com.example.OnlineCalucalor.databinding.FragmentItogBinding;

import java.util.ArrayList;


public class ItogFragment extends Fragment {

    private ItogViewModel itogViewModel;
    private FragmentItogBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        itogViewModel =
                new ViewModelProvider(this).get(ItogViewModel.class);

        binding = FragmentItogBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);



        SharedPreferences sPref = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        SharedPreferences.Editor editor = sPref.edit();

        ArrayList<String> ara = new ArrayList<>();
        ara.add(sPref.getString("itog1", " "));
        ara.add(sPref.getString("itog2", " "));
        ara.add(sPref.getString("itog3", " "));
        ara.add(sPref.getString("itog4", " "));
        ara.add(sPref.getString("itog5", " "));
        ara.add(sPref.getString("itog6", " "));
        ara.add(sPref.getString("itog7", " "));
        ara.add(sPref.getString("itog8", " "));

        ListView  lw = binding.listik;
        ArrayAdapter adapterCalculators = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, ara);
        lw.setAdapter(adapterCalculators);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
