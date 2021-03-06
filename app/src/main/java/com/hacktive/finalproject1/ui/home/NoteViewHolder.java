package com.hacktive.finalproject1.ui.home;

import androidx.recyclerview.widget.RecyclerView;

import com.hacktive.finalproject1.helper.ViewAlertDialog;
import com.hacktive.finalproject1.database.Notes;
import com.samsul.finalproject1.databinding.ItemNoteBinding;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    ItemNoteBinding binding;

    public NoteViewHolder(ItemNoteBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Notes notes) {
        binding.tvCatatan.setText(notes.getDescription());
        binding.btnCompleteTask.setOnClickListener(v -> {
            NoteAdapter.onItemClickCallBack.onItemClicked(notes);
        });

        binding.tvCatatan.setOnClickListener(v -> {
            ViewAlertDialog.showAlertDialog(v.getContext(), notes);
        });
    }



}
