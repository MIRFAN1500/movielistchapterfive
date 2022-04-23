package com.irfan.challengech5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import challengech5.databinding.ActivityMainBinding
import com.irfan.challengech5.view_model.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("TAG","Test")
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getCars().observe(this){
           print("Main activity : datanya -> $it")
        }
    }

//    private fun updateUi() {
//        viewModel.mCount.observe(this){
//            resultCount ->
//            binding.tvNumber.setText(resultCount.toString())
//        }
//    }

}