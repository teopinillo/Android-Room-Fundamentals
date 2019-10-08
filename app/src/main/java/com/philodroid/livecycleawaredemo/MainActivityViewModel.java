package com.philodroid.livecycleawaredemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> myRandomNumber = null;
    private String TAG = MainActivityViewModel.class.getSimpleName();
    private Random r;


    public MutableLiveData<String> getNumber() {
        Log.i(TAG, "Get Number");
        if (myRandomNumber != null) return myRandomNumber;
        myRandomNumber = new MutableLiveData<>();
        r = new Random();
        return createNumber();
    }

    public MutableLiveData<String> createNumber() {
        Log.i(TAG, " Create number");
        int i = r.nextInt(10 - 1) + 1;
        myRandomNumber.setValue("Number: " + i);
        return myRandomNumber;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }
}
