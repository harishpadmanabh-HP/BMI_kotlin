package com.hp.bmi_kotlin

import android.widget.TextView
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    fun calculateBmi(height: String, weight: String): String {
        val h: Float = height.toFloat()
        val w: Float = weight.toFloat()

        return (w / (h * h)).toString()
    }

    fun decreaseCount(textview : TextView){
        textview.text = (textview.text.toString().toInt()-1).toString()
    }

    fun increaseCount(textview : TextView){
        textview.text = (textview.text.toString().toInt()+1).toString()

    }
}