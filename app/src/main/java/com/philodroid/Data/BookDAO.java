package com.philodroid.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDAO {
    /*
    @Insert
    @Update
    @Delete
    @Query : Perform read/write operations. Verified at the compile time.
     */

    @Insert
    void insert(Book book);

    @Delete
    void delete(Book book);

    @Update
    long update(Book book);

    @Query("SELECT * FROM books")
    List<Book> getAll();
}
