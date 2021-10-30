package com.samsul.finalproject1.ui.insert;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.samsul.finalproject1.database.Notes;
import com.samsul.finalproject1.repository.NoteRepository;

public class NoteAddViewModel extends ViewModel {

    private final NoteRepository mNoteRepository;

    public NoteAddViewModel(Application application) {
        mNoteRepository = new NoteRepository(application);
    }

    public void insert(Notes notes) {
        mNoteRepository.insert(notes);
    }

    public void delete(Notes notes) {
        mNoteRepository.delete(notes);
    }
}
