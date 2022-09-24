package binar.academy.chapter4challenge.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import binar.academy.chapter4challenge.R
import binar.academy.chapter4challenge.databinding.FragmentCreateBinding
import binar.academy.chapter4challenge.room.DataNote
import binar.academy.chapter4challenge.room.NoteDatabase
import binar.academy.chapter4challenge.viewmodel.NoteViewModel

class CreateFragment : Fragment() {
    lateinit var binding : FragmentCreateBinding
    lateinit var shared : SharedPreferences
    var dbNote : NoteDatabase? = null
    val viewModel : NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            addNote(it)
        }

    }
    fun addNote(it : View?){
        var judul = binding.addId.text.toString()
        var isi = binding.addTitle.text.toString()
        val data = DataNote(null, title = judul, content = isi)
        viewModel.addNote(data)

        Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_createFragment_to_homeFragment)
    }
}