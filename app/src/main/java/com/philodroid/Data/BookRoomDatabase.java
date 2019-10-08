package com.philodroid.Data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.UUID;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class BookRoomDatabase extends RoomDatabase {
    private static volatile BookRoomDatabase INSTANCE;
    private static RoomDatabase.Callback bookDataBaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    public static BookRoomDatabase getBookRoomDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            BookRoomDatabase.class,
                            "book_database")
                            .addCallback(bookDataBaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract BookDAO bookDao();

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final BookDAO bDao;

        PopulateDbAsync(BookRoomDatabase db) {
            bDao = db.bookDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            bDao.deleteAll();
            Book book = new Book(UUID.randomUUID(), "First Autor", "First Book");
            bDao.insert(book);
            book = new Book(UUID.randomUUID(), "Second Author", "Second Book");
            bDao.insert(book);
            return null;
        }
    }
}
