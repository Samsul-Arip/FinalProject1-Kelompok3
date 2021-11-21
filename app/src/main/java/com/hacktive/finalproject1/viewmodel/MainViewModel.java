package com.hacktive.finalproject1.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hacktive.finalproject1.database.Notes;
import com.hacktive.finalproject1.repository.NoteRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final NoteRepository mNoteRepository;

    public MainViewModel(Application application)
    {
        mNoteRepository = new NoteRepository(application);
    }
    public LiveData<List<Notes>> getAllNotes()
    {
        return mNoteRepository.getAllNotes();
    }

    public void insert(Notes notes){
        mNoteRepository.insert(notes);
    }

    public void delete(Notes notes)
    {
        mNoteRepository.delete(notes);
    }

    public void update(Notes notes)
    {
        mNoteRepository.update(notes);
    }
}
