package com.abdullahalamodi.roomtest

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.abdullahalamodi.roomtest.database.StudentDatabase
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "student_database"

class StudentRepository private constructor(context: Context) {

    private val database: StudentDatabase = Room.databaseBuilder(
        context.applicationContext,
        StudentDatabase::class.java,
        DATABASE_NAME
    )
        .build()

    private val studentDao = database.studentDao();
    private val executor = Executors.newSingleThreadExecutor();

    fun getStudents(): LiveData<List<Student>> = studentDao.getStudents()

    fun getStudent(id: UUID): LiveData<Student?> = studentDao.getStudent(id);

    fun updateStudent(student: Student) {
        executor.execute {
            studentDao.updateStudent(student)
        }
    }

    fun addStudent(student: Student) {
        executor.execute {
            studentDao.addStudent(student)
        }
    }

    companion object {
        private var INSTANCE: StudentRepository? = null;

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = StudentRepository(context)
            }
        }

        fun get(): StudentRepository {
            return INSTANCE ?: //what's this trick ???
            throw IllegalStateException("com.abdullahalamodi.roomtest.com.abdullahalamodi.roomtest.StudentRepository must be initialized")
        }
    }
}