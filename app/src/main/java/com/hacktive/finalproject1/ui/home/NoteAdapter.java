package com.hacktive.finalproject1.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hacktive.finalproject1.database.Notes;
import com.samsul.finalproject1.databinding.ItemNoteBinding;
import com.hacktive.finalproject1.helper.NoteDiffCallback;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private final ArrayList<Notes> listNotes = new ArrayList<>();
    public static OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        NoteAdapter.onItemClickCallBack = onItemClickCallBack;
    }

    public void setListNotes(List<Notes> data) {
        final NoteDiffCallback diffCallback = new NoteDiffCallback(this.listNotes, data);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.listNotes.clear();
        this.listNotes.addAll(data);
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNoteBinding view = ItemNoteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(listNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    public interface OnItemClickCallBack {
        void onItemClicked(Notes notes);
    }


}
