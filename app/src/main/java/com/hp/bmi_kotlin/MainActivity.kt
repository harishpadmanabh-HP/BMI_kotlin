package com.hp.bmi_kotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hp.bmi_kotlin.databinding.ActivityMainBinding
import com.xw.repo.BubbleSeekBar
import com.xw.repo.BubbleSeekBar.OnProgressChangedListenerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        with(binding) {
            seekHeight.setOnProgressChangedListener(object : OnProgressChangedListenerAdapter() {
                override fun onProgressChanged(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {
                    super.onProgressChanged(bubbleSeekBar, progress, progressFloat, fromUser)
                     heightValue.text = progress.toString()
                }

                override fun getProgressOnActionUp(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float
                ) {
                    super.getProgressOnActionUp(bubbleSeekBar, progress, progressFloat)
                }

                override fun getProgressOnFinally(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {
                    super.getProgressOnFinally(bubbleSeekBar, progress, progressFloat, fromUser)
                }
            })
        }


        binding.calculateBMI.setOnClickListener{

            var weight = binding.weightValueTextView.text.toString()
            var height = binding.heightValue.text.toString()

          var bmi =   viewModel.calculateBmi(height , weight)

            Toast.makeText(applicationContext,"BMI is $bmi",Toast.LENGTH_LONG).show()

        }

    }
}