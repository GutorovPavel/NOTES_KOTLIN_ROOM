package com.example.room.screens.DetailNoteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.REPOSITORY
import com.example.room.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    fun delete(noteModel: NoteModel, onSuccess:() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel) {
                onSuccess()
            }
        }
    }

    fun update(noteModel: NoteModel, onSuccess:() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.updateNote(noteModel) {
                onSuccess()
            }
        }
    }

}