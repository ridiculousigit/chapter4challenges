package binar.academy.chapter4challenge.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import binar.academy.chapter4challenge.databinding.ItemNoteBinding
import binar.academy.chapter4challenge.room.DataNote

class NoteAdapter(val requireContext: Context, private val listNote: List<DataNote>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {
        fun data(itemData : DataNote){
            binding.datanote = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listNote[position]
        holder.data(listNote[position])

        holder.binding.btnEditNote.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToUpdateFragment(data)
            Navigation.findNavController(it).navigate(action)

        }

        holder.binding.btnDeleteNote.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDeleteFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }
}