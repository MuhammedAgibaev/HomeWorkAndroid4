package com.agibaev.quizapp.main;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<String> title = new MutableLiveData<>();

    public MainViewModel() {

        Log.d("ololo", "Main viewmodel created");
    }
}