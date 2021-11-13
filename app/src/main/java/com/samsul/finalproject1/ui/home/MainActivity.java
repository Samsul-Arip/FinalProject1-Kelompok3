package com.samsul.finalproject1.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.samsul.finalproject1.ui.ViewModelFactory;
import com.samsul.finalproject1.ui.insert.ViewDialog;
import com.samsul.finalproject1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel mainViewModel = obtainViewModel(MainActivity.this);


        noteAdapter = new NoteAdapter();

        binding.rvNote.setLayoutManager(new LinearLayoutManager(this));
        binding.rvNote.setHasFixedSize(true);
        binding.rvNote.setAdapter(noteAdapter);

        mainViewModel.getAllNotes().observe(this, notes -> {
            if(notes != null) {
                noteAdapter.setListNotes(notes);
            }
        });
        binding.fabAdd.setOnClickListener(v -> {
            ViewDialog viewDialog = new ViewDialog();
            viewDialog.showDialog(MainActivity.this);
        });

        noteAdapter.setOnItemClickCallBack(data -> {
            ViewDialog viewDialog = new ViewDialog();
            viewDialog.showconfirmation(MainActivity.this, data.getId());
        });

    }

    private static MainViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return new ViewModelProvider(activity, factory).get(MainViewModel.class);
    }
}