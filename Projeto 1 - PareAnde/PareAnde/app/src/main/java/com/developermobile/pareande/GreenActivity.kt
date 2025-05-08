package com.developermobile.pareande

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.developermobile.pareande.databinding.ActivityGreenBinding

class GreenActivity : AppCompatActivity(), View.OnClickListener {
    private val binding: ActivityGreenBinding by lazy { ActivityGreenBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

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
        finish()
    }
}