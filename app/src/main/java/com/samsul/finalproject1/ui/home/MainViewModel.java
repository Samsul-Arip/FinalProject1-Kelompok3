package com.samsul.finalproject1.ui.home;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.samsul.finalproject1.database.Notes;
import com.samsul.finalproject1.repository.NoteRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final NoteRepository mNoteRepository;

    public MainViewModel(Application application) {
        mNoteRepository = new NoteRepository(application);
    }

    LiveData<List<Notes>> getAllNotes() {
        return mNoteRepository.getAllNotes();
    }
}
