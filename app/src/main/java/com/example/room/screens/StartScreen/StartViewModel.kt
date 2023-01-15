package com.example.room.screens.StartScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room.REPOSITORY
import com.example.room.db.NoteDatabase
import com.example.room.db.repository.NoteRepositoryImpl
import com.example.room.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val dao = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRepositoryImpl(dao)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}