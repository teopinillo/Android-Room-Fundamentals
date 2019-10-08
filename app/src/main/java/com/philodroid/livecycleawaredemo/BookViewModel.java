package com.philodroid.livecycleawaredemo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.philodroid.Data.Book;
import com.philodroid.Data.BookDAO;
import com.philodroid.Data.BookRoomDatabase;


public class BookViewModel extends AndroidViewModel {

    private BookDAO bookDao;
    private BookRoomDatabase bookRoomDatabase;
    public BookViewModel(@NonNull Application application) {
        super(application);
        bookRoomDatabase = BookRoomDatabase.getBookRoomDatabase(application);
        bookDao = bookRoomDatabase.bookDao();
    }

    public void insert(Book book) {
        new InsertAsyncTask().execute(book);
    }

    class InsertAsyncTask extends AsyncTask<Book, Void, Void> {

        @Override
        protected Void doInBackground(Book... books) {
            Book b = books[0];
            bookDao.insert(b);
            return null;
        }
    }
}
