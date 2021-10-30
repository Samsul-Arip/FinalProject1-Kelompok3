package com.samsul.finalproject1.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.samsul.finalproject1.database.NoteDao;
import com.samsul.finalproject1.database.NoteRoomDatabase;
import com.samsul.finalproject1.database.Notes;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private final NoteDao mNotesDao;

    private final ExecutorService executorService;

    public NoteRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);

        mNotesDao = db.noteDao();
    }

    public LiveData<List<Notes>> getAllNotes() {
        return mNotesDao.getAllNotes();
    }

    public void insert(final Notes notes) {
        executorService.execute(() -> mNotesDao.insert(notes));
    }

    public void delete(final Notes notes) {
        executorService.execute(() -> mNotesDao.delete(notes));
    }

    public void update(final Notes notes) {
        executorService.execute(() -> mNotesDao.update(notes));
    }

}
