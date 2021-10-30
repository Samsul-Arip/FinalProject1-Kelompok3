package com.samsul.finalproject1.ui.insert;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.samsul.finalproject1.R;
import com.samsul.finalproject1.database.Notes;
import com.samsul.finalproject1.ui.ViewModelFactory;

public class ViewDialog {

    private NoteAddViewModel noteAddViewModel;

    public void showDialog(AppCompatActivity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.view_dialog_add);

        noteAddViewModel = obtainViewModel(activity);

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
                noteAddViewModel.insert(notes);
                Toast.makeText(activity, "Berhasil menambahkan catatan", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

        });

        dialog.show();
    }

    private static NoteAddViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return new ViewModelProvider(activity, factory).get(NoteAddViewModel.class);
    }
}
