package com.samsul.finalproject1.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Notes notes);

    @Update()
    void update(Notes notes);

    @Delete()
    void delete(Notes notes);

    @Query("SELECT * FROM Notes ORDER BY id ASC")
    LiveData<List<Notes>> getAllNotes();
}
