package com.hacktive.finalproject1.helper;

import androidx.recyclerview.widget.DiffUtil;

import com.hacktive.finalproject1.database.Notes;

import java.util.List;

public class NoteDiffCallback extends DiffUtil.Callback {

    private final List<Notes> mOldNotesList;
    private final List<Notes> mNewNotesList;

    public NoteDiffCallback(List<Notes> mOldNotesList, List<Notes> mNewNotesList) {
        this.mOldNotesList = mOldNotesList;
        this.mNewNotesList = mNewNotesList;
    }

    @Override
    public int getOldListSize() {
        return mOldNotesList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewNotesList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return  mOldNotesList.get(oldItemPosition).getId() == mNewNotesList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Notes oldData = mOldNotesList.get(oldItemPosition);
        final Notes newData = mNewNotesList.get(newItemPosition);

        return oldData.getDescription().equals(newData.getDescription());
    }


}
