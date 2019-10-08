package com.philodroid.Data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {
    //@Ignore
    // T t;
    //@ForeignKey
    //E e;
    //
    public String bookName;
    // @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    String id;
    @ColumnInfo(name = "author")
    String author;

    public Book(String id, String author, String bookName) {
        this.id = id;
        this.author = author;
        this.bookName = bookName;
    }
}
