package binar.academy.chapter4challenge.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import binar.academy.chapter4challenge.R
import binar.academy.chapter4challenge.databinding.FragmentUpdateBinding
import binar.academy.chapter4challenge.room.DataNote
import binar.academy.chapter4challenge.viewmodel.NoteViewModel

class UpdateFragment : Fragment() {

    val notes by navArgs<UpdateFragmentArgs>()
    val viewModel : NoteViewModel by viewModels()
    lateinit var binding : FragmentUpdateBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(layoutInflater,container,false)

        binding.updateId.setText(notes.data.title)
        binding.updateTitle.setText(notes.data.content)

        binding.btnUpdate.setOnClickListener {
            updateNote(it)
        }


        return binding.root

    }
    private fun updateNote(it: View?) {
        var judul = binding.updateId.text.toString()
        var isi = binding.updateTitle.text.toString()

        val data = DataNote(notes.data.id, title = judul, content = isi)
        viewModel.updateNote(data)

        Toast.makeText(context, "Update Successful !", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
    }
}
