package com.philodroid.livecycleawaredemo;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityDataGenerator extends ViewModel {
    private String myRandomNumber = null;
    private String TAG = MainActivityDataGenerator.class.getSimpleName();


    public String getNumber() {
        Log.i(TAG, "Get Number");
        if (myRandomNumber != null) return myRandomNumber;
        myRandomNumber = this.createNumber();
        return myRandomNumber;
    }

    private String createNumber() {
        Log.i(TAG, " Create number");
        Random r = new Random();
        int i = r.nextInt(10 - 1) + 1;
        return "Number: " + i;
    }
}
