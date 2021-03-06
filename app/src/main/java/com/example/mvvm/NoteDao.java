package com.example.mvvm;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface NoteDao {

    @Insert
    void insertNote(NoteEntity note);
}
