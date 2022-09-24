package binar.academy.chapter4challenge.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import binar.academy.chapter4challenge.R
import binar.academy.chapter4challenge.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var shared : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLogin.setOnClickListener {
            var getDataEmail = shared.getString("email","")
            var getDataPw = shared.getString("password","")

            var email = binding.etEmaillog.text.toString()
            var pw = binding.etPasslog.text.toString()

            if (email.isEmpty() || pw.isEmpty()){
                Toast.makeText(context,"Fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            } else if (email == getDataEmail.toString() && pw == getDataPw.toString()){
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                Toast.makeText(context,"Successfully Login. Please wait...", Toast.LENGTH_SHORT).show()

            } else if (email != getDataEmail.toString() || pw != getDataPw.toString()){
                Toast.makeText(context,"You've entered incorrect email or password.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }
}