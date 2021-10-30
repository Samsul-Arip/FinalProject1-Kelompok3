package com.samsul.finalproject1.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.samsul.finalproject1.ui.home.MainViewModel;
import com.samsul.finalproject1.ui.insert.NoteAddViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final Application mApplication;

    private ViewModelFactory(Application application) {
        mApplication = application;
    }

    public static ViewModelFactory getInstance(Application application) {
        if(INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(application);
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(mApplication);
        } else if(modelClass.isAssignableFrom(NoteAddViewModel.class)) {
            return (T) new NoteAddViewModel(mApplication);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
