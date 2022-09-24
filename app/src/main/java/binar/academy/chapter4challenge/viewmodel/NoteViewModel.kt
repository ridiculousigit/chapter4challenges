package binar.academy.chapter4challenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import binar.academy.chapter4challenge.repository.NoteRepository
import binar.academy.chapter4challenge.room.DataNote
import binar.academy.chapter4challenge.room.NoteDatabase

class NoteViewModel(application : Application) : AndroidViewModel(application) {

    private val repository : NoteRepository

    init {
        val dao = NoteDatabase.getInstance(application)!!.noteDao()
        repository = NoteRepository(dao)
    }

    fun addNote(note : DataNote) {
        repository.insertNote(note)
    }

    fun getNote(): LiveData<List<DataNote>> = repository.getAllNote()

    fun deleteNote(id : Int) {
        repository.deleteNote(id)
    }

    fun updateNote(note : DataNote) {
        repository.updateNote(note)
    }
}