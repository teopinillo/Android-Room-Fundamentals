package com.philodroid.Data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

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
    UUID id;
    @ColumnInfo(name = "author")
    String author;

    public Book(UUID id, String author, String bookName) {
        this.id = id;
        this.author = author;
        this.bookName = bookName;
    }
}
