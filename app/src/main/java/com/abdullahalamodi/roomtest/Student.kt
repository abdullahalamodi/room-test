package com.abdullahalamodi.roomtest

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Student(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    var name: String = "",
    var number: Int = 0,
    var passed: Boolean = true
)