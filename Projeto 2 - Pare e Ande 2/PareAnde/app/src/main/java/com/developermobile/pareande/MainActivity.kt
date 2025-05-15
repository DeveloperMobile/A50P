package com.developermobile.pareande

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.developermobile.pareande.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)
        supportActionBar?.hide()

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left + binding.main.paddingStart, systemBars.top,
                systemBars.right + binding.main.paddingEnd, systemBars.bottom
            )
            insets
        }

        binding.btnTrocar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_trocar) {
            chamarOutra()
        }
    }

    private fun chamarOutra() {
       if (!flag) {
           binding.main.setBackgroundResource(R.color.green)
           binding.tvMsg.text = getString(R.string.msg_walk)
           binding.btnTrocar.text = getString(R.string.btn_replace)
           flag = true
       } else {
           binding.main.setBackgroundResource(R.color.red)
           binding.tvMsg.text = getString(R.string.msg_stop)
           binding.btnTrocar.text = getString(R.string.btn_replace)
           flag = false

       }
    }
}