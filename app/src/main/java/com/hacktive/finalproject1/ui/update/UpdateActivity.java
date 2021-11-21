package com.hacktive.finalproject1.ui.update;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hacktive.finalproject1.database.Notes;
import com.samsul.finalproject1.databinding.ActivityUpdateBinding;
import com.hacktive.finalproject1.ui.ViewModelFactory;
import com.hacktive.finalproject1.viewmodel.MainViewModel;

public class UpdateActivity extends AppCompatActivity {

    public static final String ID = "ID";
    public static final String CATATAN = "ID";

    private ActivityUpdateBinding binding;
    private MainViewModel updateViewModel;
    int id;
    String catatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        updateViewModel = obtainViewModel(this);
        Intent intent = getIntent();
        catatan = intent.getStringExtra(CATATAN);
        id = intent.getIntExtra("uid", 0);
        binding.edtEditNote.setText(catatan);

        listener();
    }

    private void listener() {
        binding.btnEdit.setOnClickListener(v -> {
            Notes notes = new Notes();
            notes.setId(id);
            notes.setDescription(binding.edtEditNote.getText().toString().trim());
            updateViewModel.update(notes);
            Toast.makeText(this, "Berhasil Edit catatan", Toast.LENGTH_SHORT).show();
            finish();
        });
        binding.imgBackk.setOnClickListener(v -> {
            this.finish();
        });
    }


    private static MainViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return new ViewModelProvider(activity, factory).get(MainViewModel.class);
    }


}