package binar.academy.chapter4challenge.repository

import androidx.lifecycle.LiveData
import binar.academy.chapter4challenge.room.DataNote
import binar.academy.chapter4challenge.room.NoteDAO

class NoteRepository(val dao : NoteDAO) {

    fun getAllNote(): LiveData<List<DataNote>> {
        return dao.getDataNote()
    }
    fun insertNote(note : DataNote){
        dao.insertNote(note)
    }
    fun deleteNote(id : Int){
        dao.deleteNote(id)
    }
    fun updateNote(note : DataNote){
        dao.updateNote(note)
    }

}