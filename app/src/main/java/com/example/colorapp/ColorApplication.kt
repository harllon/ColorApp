package com.example.colorapp

import android.app.Application
import com.example.colorapp.colorRoom.ColorDatabase
import com.example.colorapp.colorRoom.ColorRepository

class ColorApplication : Application() {
    val database by lazy { ColorDatabase.getDatabase(this) }
    val repository by lazy { ColorRepository(database.colorDao()) }
}