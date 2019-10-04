package com.philodroid.livecycleawaredemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    private MainActivityDataGenerator dataGenerator;
    private TextView tvNumber;
    private String randomN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Owner onCreate");
        getLifecycle().addObserver(new MainActivityObserver());
        dataGenerator = new MainActivityDataGenerator();
        tvNumber = findViewById(R.id.tvNumber);
        randomN = dataGenerator.getNumber();
        tvNumber.setText(randomN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Owner Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Owner on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Owner onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Owner onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Owner onStop");
    }
}
