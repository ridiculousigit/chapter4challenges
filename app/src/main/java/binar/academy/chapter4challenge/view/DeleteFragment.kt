package binar.academy.chapter4challenge.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import binar.academy.chapter4challenge.R
import binar.academy.chapter4challenge.databinding.FragmentDeleteBinding
import binar.academy.chapter4challenge.room.NoteDatabase
import binar.academy.chapter4challenge.viewmodel.NoteViewModel

class DeleteFragment : Fragment() {

    lateinit var binding :FragmentDeleteBinding
    lateinit var shared : SharedPreferences
    var dbNote : NoteDatabase? = null
    val viewModel : NoteViewModel by viewModels()
    val notes by navArgs<UpdateFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeleteBinding.inflate(inflater,container,false)

        binding.btnYes.setOnClickListener {
            viewModel.deleteNote(notes.data.id!!)
            Navigation.findNavController(it!!).navigate(R.id.action_deleteFragment_to_homeFragment)
            Toast.makeText(context,"Berhasil Delete Note", Toast.LENGTH_SHORT).show()
        }
        binding.btnNo.setOnClickListener {
            Toast.makeText(context,"Batal Delete Note", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it!!).navigate(R.id.action_deleteFragment_to_homeFragment)
        }

        return binding.root
    }
}