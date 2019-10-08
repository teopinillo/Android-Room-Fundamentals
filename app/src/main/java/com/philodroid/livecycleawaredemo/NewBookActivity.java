package com.philodroid.livecycleawaredemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class NewBookActivity extends AppCompatActivity {

    public static final String NEW_AUTHOR = "NEW_AUTHOR";
    public static final String NEW_BOOK = "NEW_BOOK";

    private ImageButton btSave;
    private EditText etAuthor;
    private EditText etBookTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        btSave = findViewById(R.id.btSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAuthor = findViewById(R.id.etAuthor);
                etBookTitle = findViewById(R.id.etBookTitle);
                Intent resultIntent = new Intent();
                String author = etAuthor.getText().toString();
                String title = etBookTitle.getText().toString();
                if (!author.isEmpty() && !title.isEmpty()) {
                    resultIntent.putExtra(NEW_AUTHOR, author);
                    resultIntent.putExtra(NEW_BOOK, title);
                    setResult(Activity.RESULT_OK, resultIntent);
                } else {
                    setResult(Activity.RESULT_CANCELED, resultIntent);
                }
                finish();
            }
        });
    }


}
