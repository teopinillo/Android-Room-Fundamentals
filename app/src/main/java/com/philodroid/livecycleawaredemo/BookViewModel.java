package com.philodroid.livecycleawaredemo;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.philodroid.Data.Book;
import com.philodroid.Data.BookDAO;
import com.philodroid.Data.BookRoomDatabase;


public class BookViewModel extends AndroidViewModel {

    private static String TAG = BookViewModel.class.getSimpleName();
    private BookDAO bookDao;
    private BookRoomDatabase bookRoomDatabase;
    public BookViewModel(@NonNull Application application) {
        super(application);
        Log.i(TAG, "BookViewModel super constructor...done");
        Log.i(TAG, "get RoomDatabase Instance...");
        bookRoomDatabase = BookRoomDatabase.getBookRoomDatabase(application);
        Log.i(TAG, "done.\n get bookDao...");
        bookDao = bookRoomDatabase.bookDao();
        Log.i(TAG, "done.");
    }

    public void insert(Book book) {
        new InsertAsyncTask().execute(book);
    }

    private class InsertAsyncTask extends AsyncTask<Book, Void, Void> {

        @Override
        protected Void doInBackground(Book... books) {
            Book b = books[0];
            bookDao.insert(b);
            return null;
        }
    }
}
