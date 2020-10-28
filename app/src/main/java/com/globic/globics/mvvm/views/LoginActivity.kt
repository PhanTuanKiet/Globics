package com.globic.globics.mvvm.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.globic.globics.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { view ->

        }

    }

}