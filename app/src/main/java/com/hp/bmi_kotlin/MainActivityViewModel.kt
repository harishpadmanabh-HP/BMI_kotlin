package com.hp.bmi_kotlin

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    fun calculateBmi(height: String, weight: String): String {
        val h: Float = height.toFloat()
        val w: Float = weight.toFloat()

        return (w / (h * h)).toString()
    }
}