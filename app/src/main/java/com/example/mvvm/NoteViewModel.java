package com.example.mvvm;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class NoteViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteRoomDatabase noteRoomDB;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRoomDB = NoteRoomDatabase.getDatabase(application);
        noteDao = noteRoomDB.noteDao();
    }

    public void insertNote(NoteEntity note) {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }
}
