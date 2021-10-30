package com.samsul.finalproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.samsul.finalproject1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fabAdd.setOnClickListener(v -> {
            ViewDialog viewDialog = new ViewDialog();
            viewDialog.showDialog(MainActivity.this, "");
        });
    }
}