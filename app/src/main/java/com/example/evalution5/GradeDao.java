package com.example.evalution5;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GradeDao {
    @Query("SELECT * FROM grades")
    List<Grade> getAll();

    @Insert
    void insertAll(Grade... grades);

    @Delete
    void delete(Grade grade);
}
