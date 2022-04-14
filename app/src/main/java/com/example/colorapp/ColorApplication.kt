package com.example.colorapp

import android.app.Application
import com.example.colorapp.ColorRoom.ColorDatabase
import com.example.colorapp.ColorRoom.ColorRepository

class ColorApplication : Application() {
    val database by lazy { ColorDatabase.getDatabase(this) }
    val repository by lazy { ColorRepository(database.colorDao()) }
}