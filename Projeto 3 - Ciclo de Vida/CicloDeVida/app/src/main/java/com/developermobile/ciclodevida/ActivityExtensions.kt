package com.developermobile.ciclodevida

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.toast(message: CharSequence, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}