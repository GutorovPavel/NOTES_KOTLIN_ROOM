package com.example.room.db.repository

import androidx.lifecycle.LiveData
import com.example.room.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun updateNote(noteModel: NoteModel, onSuccess: () -> Unit)
}