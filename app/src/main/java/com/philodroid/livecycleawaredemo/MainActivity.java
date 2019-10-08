package com.philodroid.livecycleawaredemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

//@href https://developer.android.com/topic/libraries/architecture/livedata
public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    private MainActivityViewModel model;
    private TextView tvNumber;
    private MutableLiveData<String> randomN;
    private Button btFecth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Owner onCreate");
        tvNumber = findViewById(R.id.tvNumber);
        btFecth = findViewById(R.id.btFetch);

        getLifecycle().addObserver(new MainActivityObserver());

        final Observer<String> numberObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newNumber) {
                //Update the UI
                tvNumber.setText(newNumber);
            }
        };

        btFecth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.createNumber();
            }
        });
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.

        model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        randomN = model.getNumber();
        randomN.observe(this, numberObserver);
        tvNumber.setText(randomN.getValue());

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
