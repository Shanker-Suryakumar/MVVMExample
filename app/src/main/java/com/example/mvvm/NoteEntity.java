package com.example.mvvm;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// If here table name is not mentioned by default room will take the class name as the table name
@Entity(tableName = "notes")
public class NoteEntity {
    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    public NoteEntity(String id, String mNote) {
        this.id = id;
        this.mNote = mNote;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getNote() {
        return mNote;
    }
}
