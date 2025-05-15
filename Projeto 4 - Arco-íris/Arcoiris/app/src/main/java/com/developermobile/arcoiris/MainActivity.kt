package com.developermobile.arcoiris

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.developermobile.arcoiris.databinding.ActivityMainBinding
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {
    val bindin: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var hexCor = arrayOf("00", "00", "00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(bindin.root)
        ViewCompat.setOnApplyWindowInsetsListener(bindin.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left - bindin.main.paddingStart, systemBars.top,
                systemBars.right - bindin.main.paddingRight, systemBars.bottom)
            insets
        }

        setListener()
        changeColor()
    }

    private fun setListener() {
        bindin.sbRed.setOnSeekBarChangeListener(seekBarListener(0))
        bindin.sbGreen.setOnSeekBarChangeListener(seekBarListener(1))
        bindin.sbBlue.setOnSeekBarChangeListener(seekBarListener(2))
    }

    private fun seekBarListener(cor: Byte): SeekBar.OnSeekBarChangeListener {
        return object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                hitColor(progress, cor)
            }

            private fun hitColor(position: Int, cor: Byte) {
                var c = Integer.toHexString(position)
                hexCor[cor.toInt()] = (if (c.length == 2) "" else "0") + c
                changeColor()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) { }

            override fun onStopTrackingTouch(seekBar: SeekBar) { }
        }
    }

    private fun changeColor() {
        bindin.selectedColor.text = "#%s%s%s".format(hexCor[0], hexCor[1], hexCor[2])
        bindin.colorBar.setBackgroundColor(
            "#%s%s%s".format(hexCor[0], hexCor[1], hexCor[2]).toColorInt())
    }
}