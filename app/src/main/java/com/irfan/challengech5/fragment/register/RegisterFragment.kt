package com.irfan.challengech5.fragment.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import challengech5.databinding.FragmentRegisterBinding
import com.irfan.challengech5.database.model_db.create_db.UserDatabase
import com.irfan.challengech5.database.model_db.model_db.User

class RegisterFragment : Fragment() {


    private var user_db : UserDatabase? = null
    lateinit var binding : FragmentRegisterBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user_db = UserDatabase.getInstance(requireContext())


        var username =""
        var email =""
        var password =""
        var repassword =""

        binding.btnRegister.setOnClickListener {
            username = binding.etUsername.text.toString()
            email = binding.etEmail.text.toString()
            password = binding.etPassword.text.toString()
            repassword = binding.etConfirmPassword.text.toString()

            val userList = User(
                null,
                username,
                email,
                password,
                repassword
            )

            if(username.isEmpty() || email.isEmpty() || password.isEmpty() || repassword.isEmpty()){
                Toast.makeText(requireContext(),"Silahkan isi kolom terlebih dahulu",Toast.LENGTH_LONG).show()
            }else{
                Thread{
                    val result = user_db?.UserDao()?.insertUser(userList)
                    activity?.runOnUiThread{
                        if (result != 0.toLong()) {
                            Toast.makeText(
                                requireContext(),
                                "Sukses Menambahkan ${userList.username}",
                                Toast.LENGTH_LONG
                            ).show()
                            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Gagal menambahkan ${userList.username}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }.start()
            }
        }
//
//        var name = arguments.name
//        var price = arguments.price.toString()

//        binding.tvName.setText(name)
//        binding.tvPrice.setText(price)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }


}