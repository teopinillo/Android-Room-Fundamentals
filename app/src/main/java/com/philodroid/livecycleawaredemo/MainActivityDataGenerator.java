package com.philodroid.livecycleawaredemo;

import android.util.Log;

import java.util.Random;

public class MainActivityDataGenerator {
    private String myRandomNumber = null;
    private String TAG = MainActivityDataGenerator.class.getSimpleName();


    public String getNumber() {
        Log.i(TAG, "Get NUmber");
        if (myRandomNumber != null) return myRandomNumber;
        return this.createNumber();
    }

    private String createNumber() {
        Log.i(TAG, " Create number");
        Random r = new Random();
        int i = r.nextInt(10 - 1) + 1;
        return "Number: " + i;
    }
}
