package com.example.evalution5;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Grade.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GradeDao gradeDao();
}
