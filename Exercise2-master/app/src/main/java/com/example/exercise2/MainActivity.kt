package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countButton: Button = findViewById(R.id.buttonCalculate)

        countButton.setOnClickListener{ calculate() }

        var resetButton: Button = findViewById(R.id.buttonReset)

        resetButton.setOnClickListener { reset() }
    }

    private fun calculate(){
        var weight: Double = editTextWeight.text.toString().toDouble()
        var height: Double = editTextHeight.text.toString().toDouble()
        var bmi: Double
        var df = DecimalFormat("#.##")

        bmi = weight / Math.pow((height/100),2.0)

        df.roundingMode = RoundingMode.CEILING
        textViewBMI.text = df.format(bmi).toString()

        val bmiImageView: ImageView = findViewById(R.id.imageViewProfile)

        val bmiPic = when(bmi){
            in 0.0..18.4 -> R.drawable.under
            in 18.5..24.9 -> R.drawable.normal
            else -> R.drawable.over
        }

        bmiImageView.setImageResource(bmiPic)

    }

    private fun reset(){
        editTextHeight.text = null
        editTextWeight.text = null

        textViewBMI.text = "BMI :"

        imageViewProfile.setImageResource(R.drawable.empty)
    }

}
