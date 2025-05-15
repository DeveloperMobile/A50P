package com.developermobile.ciclodevida

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.developermobile.ciclodevida.databinding.ActivityMainBinding
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toast("1. OnCreate")

        binding.btnCall.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, "http://www.google.com.br".toUri()))
        }
    }

    override fun onStart() {
        super.onStart()
        toast("2. OnStart")
    }

    override fun onResume() {
        super.onResume()
        toast("3. OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        toast("4. OnRestart")
    }

    override fun onPause() {
        super.onPause()
        toast("5. OnPause")
    }

    override fun onStop() {
        super.onStop()
        toast("6. OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        toast("7. OnDestroy")
    }
}