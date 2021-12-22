package com.example.OnlineCalucalor.ui.itog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItogViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ItogViewModel() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}
