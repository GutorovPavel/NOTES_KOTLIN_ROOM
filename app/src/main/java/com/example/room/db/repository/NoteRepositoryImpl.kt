package com.example.room.db.repository

import androidx.lifecycle.LiveData
import com.example.room.db.dao.NoteDao
import com.example.room.model.NoteModel

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insertNote(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.deleteNote(noteModel)
        onSuccess()
    }

    override suspend fun updateNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.updateNote(noteModel)
        onSuccess()
    }
}