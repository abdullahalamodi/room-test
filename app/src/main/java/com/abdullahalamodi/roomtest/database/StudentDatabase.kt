package com.abdullahalamodi.roomtest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdullahalamodi.roomtest.Student

@Database(entities = [Student::class ], version=1,exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao;
}