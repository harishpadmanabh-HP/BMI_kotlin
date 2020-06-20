package com.hp.bmi_kotlin

import android.graphics.Color
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
    private var isMale = false
    private var isFemale = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.apply {

            genderMaleImageView.setOnClickListener {

                isMale = true;
                isFemale = false;

                updateGenderBackgroundColor(isMale, isFemale)


            }
            genderFemaleImageView.setOnClickListener {
                isFemale = true
                isMale = false
                updateGenderBackgroundColor(isMale, isFemale)

            }


        }



        binding.weightMinusFab.setOnClickListener {
            viewModel.decreaseCount(binding.weightValueTextView)
        }
        binding.ageMinusFab.setOnClickListener {
            viewModel.decreaseCount(binding.ageValueTextView)

        }

        binding.weightPlusFab.setOnClickListener {
            viewModel.increaseCount(binding.weightValueTextView)

        }

        binding.agePlusFab.setOnClickListener {
            viewModel.increaseCount(binding.ageValueTextView)

        }

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


        binding.calculateBMI.setOnClickListener {

            var weight = binding.weightValueTextView.text.toString()
            var height = binding.heightValue.text.toString()

            var bmi = viewModel.calculateBmi(height, weight)

            Toast.makeText(applicationContext, "BMI is $bmi", Toast.LENGTH_LONG).show()

        }

    }

    private fun updateGenderBackgroundColor(male: Boolean, female: Boolean) {

        if (male) {
            binding.genderMaleImageView.setBackgroundColor(resources.getColor(R.color.genderSelectodColor))
            binding.genderFemaleImageView.setBackgroundColor(resources.getColor(R.color.colorWhite))

        } else if (female) {
            binding.genderMaleImageView.setBackgroundColor(resources.getColor(R.color.colorWhite))
            binding.genderFemaleImageView.setBackgroundColor(resources.getColor(R.color.genderSelectodColor))

        }

    }
}