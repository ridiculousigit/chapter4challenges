package binar.academy.chapter4challenge.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.chapter4challenge.R
import binar.academy.chapter4challenge.databinding.FragmentHomeBinding
import binar.academy.chapter4challenge.viewmodel.NoteViewModel

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var shared : SharedPreferences
    private val viewModel : NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        viewModel.getNote().observe(viewLifecycleOwner) { listNote ->
            binding.rvHome.layoutManager = LinearLayoutManager(requireContext())
            binding.rvHome.adapter = NoteAdapter(requireContext(),listNote)
        }
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        val getUsername = shared.getString("user","")
        binding.tvNameout.text = "Hi, $getUsername"

        binding.btnLogout.setOnClickListener {
            val pref = shared.edit()
            pref.clear()
            pref.apply()
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
            Toast.makeText(context,"See You !", Toast.LENGTH_SHORT).show()
        }

        binding.btnCreate.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createFragment)
        }
    }
}