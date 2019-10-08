package com.philodroid.livecycleawaredemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.philodroid.Data.Book;

import java.util.UUID;

//@href https://developer.android.com/topic/libraries/architecture/livedata
public class MainActivity extends AppCompatActivity {
    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 9;
    private static String TAG = MainActivity.class.getSimpleName();
    private MainActivityViewModel model;
    private BookViewModel bookViewModel;
    private TextView tvNumber;
    private MutableLiveData<String> randomN;
    private Button btFecth;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Owner onCreate");
        tvNumber = findViewById(R.id.tvNumber);
        btFecth = findViewById(R.id.btFetch);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddBook = new Intent(getApplicationContext(), NewBookActivity.class);
                startActivityForResult(intentAddBook, NEW_NOTE_ACTIVITY_REQUEST_CODE);
            }
        });


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
        try {
            bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e(TAG, e.getLocalizedMessage());
        }
        randomN = model.getNumber();
        randomN.observe(this, numberObserver);
        tvNumber.setText(randomN.getValue());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE) {
            if (data.hasExtra(NewBookActivity.NEW_AUTHOR)) {
                UUID id = UUID.randomUUID();
                String n = data.getStringExtra(NewBookActivity.NEW_AUTHOR);
                String t = data.getStringExtra(NewBookActivity.NEW_BOOK);
                Book iBook = new Book(id, n, t);
                bookViewModel.insert(iBook);
                Toast.makeText(getApplicationContext(), R.string.saved, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), R.string.not_saved, Toast.LENGTH_LONG).show();
            }
        }
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
