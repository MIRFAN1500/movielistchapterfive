package com.irfan.challengech5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import challengech5.databinding.FragmentPostBinding

class PostFragment : Fragment() {


    lateinit var binding : FragmentPostBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentPostBinding.inflate(inflater,container,false)
        return binding.root
    }


}