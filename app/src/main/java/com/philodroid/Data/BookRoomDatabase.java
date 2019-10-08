package com.philodroid.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version = 1)
public abstract class BookRoomDatabase extends RoomDatabase {
    private static BookRoomDatabase instance;

    public static synchronized BookRoomDatabase getBookRoomDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    BookRoomDatabase.class,
                    "user-database")
                    .build();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

    public abstract BookDao bookDao();
}
