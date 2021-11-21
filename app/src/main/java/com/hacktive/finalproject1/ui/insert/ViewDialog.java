package com.hacktive.finalproject1.ui.insert;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.hacktive.finalproject1.ui.ViewModelFactory;
import com.hacktive.finalproject1.viewmodel.MainViewModel;
import com.samsul.finalproject1.R;
import com.hacktive.finalproject1.database.Notes;

public class ViewDialog {

    private MainViewModel mainViewModel;

    public void showDialog(AppCompatActivity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.view_dialog_add);

        mainViewModel = obtainViewModel(activity);

        ImageView close = dialog.findViewById(R.id.imgClose);
        ImageView add = dialog.findViewById(R.id.imgAdd);
        EditText edtAdd = dialog.findViewById(R.id.edtNote);


        close.setOnClickListener(v -> {
            dialog.dismiss();
        });

        add.setOnClickListener(v -> {
            Notes notes = new Notes();
            String description = edtAdd.getText().toString().trim();
            if(description.isEmpty()) {
                Toast.makeText(activity, "Silahkan tambahkan catatan", Toast.LENGTH_SHORT).show();
            } else {
                notes.setDescription(description);
                mainViewModel.insert(notes);
                Toast.makeText(activity, "Berhasil menambahkan catatan", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

        });

        dialog.show();
    }

    public void showconfirmation(AppCompatActivity activity, int idNotes) {
        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(activity);
        alerBuilder.setTitle("Apakah anda yakin!!");
        alerBuilder.setMessage("Konfirmasi pilihan anda")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> {
                    Notes notes = new Notes();
                    notes.setId(idNotes);
                    mainViewModel = obtainViewModel(activity);
                    mainViewModel.delete(notes);
                    Toast.makeText(activity, "Task complete", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", (dialog, id) -> {
                    dialog.cancel();
                });
        AlertDialog alertDialog = alerBuilder.create();
        alertDialog.show();
    }

    private static MainViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return new ViewModelProvider(activity, factory).get(MainViewModel.class);
    }
}
