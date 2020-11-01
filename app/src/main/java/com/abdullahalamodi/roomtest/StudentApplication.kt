package com.abdullahalamodi.roomtest

import android.app.Application

class StudentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        StudentRepository.initialize(applicationContext); //applicationContext for long object life
    }
}