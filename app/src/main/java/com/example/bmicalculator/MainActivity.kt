package com.example.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.NumberPicker
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    var doubleHeight: Double = 1.0
    var doubleWeight: Double = 1.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.customStatusBarColor)
        }

        val HeightPicker = findViewById<NumberPicker>(R.id.HeightPicker)
        val WeightPicker = findViewById<NumberPicker>(R.id.WeightPicker)
        val CalculateBtn = findViewById<Button>(R.id.CalculateBtn)
        val MaleLayout = findViewById<RelativeLayout>(R.id.MaleLayout)
        val FemaleLayout = findViewById<RelativeLayout>(R.id.FemaleLayout)
        var isItemClicked = false
        //06C46C   80807D
        HeightPicker.minValue = 100
        HeightPicker.maxValue = 250

        WeightPicker.minValue = 30
        WeightPicker.maxValue = 150


        MaleLayout.setOnClickListener {
            MaleLayout.setBackgroundResource(R.drawable.shape_after_clicking)
            FemaleLayout.setBackgroundResource(R.drawable.shape_after_clicking_another)
            isItemClicked = true

        }
        FemaleLayout.setOnClickListener {
            FemaleLayout.setBackgroundResource(R.drawable.shape_after_clicking)
            MaleLayout.setBackgroundResource(R.drawable.shape_after_clicking_another)
            isItemClicked = true
        }

        HeightPicker.setOnValueChangedListener { Hpicker, HoldVal, HnewVal ->
            HeightPicker.value = HnewVal
        }

        WeightPicker.setOnValueChangedListener { Wpicker, WoldVal, WnewVal ->
            WeightPicker.value = WnewVal
        }
            // Set the Calculate button click listener here
            CalculateBtn.setOnClickListener {

                if (isItemClicked == true) {
                    val height = HeightPicker.value.toDouble() / 100  // Convert to meters
                    val weight = WeightPicker.value.toDouble()
                    val bmi = CalculateBMI(height, weight)

                    val intent = Intent(this, ResultPage::class.java)
                    intent.putExtra("BMI", bmi)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Please Select your Gender First!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun CalculateBMI(height: Double, weight: Double): Double {
        return weight / (height * height)
    }