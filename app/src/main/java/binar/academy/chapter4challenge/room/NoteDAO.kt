package binar.academy.chapter4challenge.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note : DataNote)

    @Query("SELECT * FROM DataNote ORDER BY id DESC ")
    fun getDataNote(): LiveData<List<DataNote>>

    @Query("DELETE FROM DataNote WHERE id=:id")
    fun deleteNote(id: Int) : Int

    @Update
    fun updateNote(note : DataNote)
}