package com.example.bmicalculator

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

class ResultPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.customStatusBarColor)
        }


        val reCalculateBtn = findViewById<Button>(R.id.ReCalculateBtn)
        val commentConsidered = findViewById<TextView>(R.id.Comment)
        val commentDescription = findViewById<TextView>(R.id.CommentDesc)

        val bmi = intent.getDoubleExtra("BMI", 0.0)

        val bmiResult = findViewById<TextView>(R.id.bmiResult)
        bmiResult.text = String.format("%.2f", bmi)

        if(bmi<18.5){
            commentConsidered.text = "Under Weight"
            commentDescription.text = "To improve a BMI below 18.5, focus on a balanced diet rich in nutrients, increase calorie intake, and engage in strength training exercises to build muscle. Consult a healthcare professional or dietitian for a personalized plan to ensure safe and sustainable weight gain."
        }
        else if(bmi<24.9){
            commentConsidered.text = "Normal Weight"
            commentDescription.text = "To maintain a healthy BMI (18.5-24.9), prioritize a well-rounded diet with fruits, vegetables, lean proteins, and whole grains. Incorporate regular exercise, such as cardio and strength training, and stay hydrated. Keep a balanced lifestyle to support your overall well-being."
        }
        else if(bmi<29.9){
            commentConsidered.text = "Overweight"
            commentDescription.text = "For a BMI between 24.9 and 29.9, focus on portion control and healthier food choices, reducing refined sugars and saturated fats. Incorporate regular aerobic exercise and strength training to burn calories and build muscle. Consult a healthcare provider for personalized guidance on weight management."
        }
        else if(bmi<34.9){
            commentConsidered.text = "Obesity (Class 1)"
            commentDescription.text = "For a BMI between 29.9 and 34.9, prioritize a balanced, calorie-controlled diet with whole foods. Increase physical activity, aiming for at least 150 minutes of moderate exercise per week. Consult a healthcare professional for a tailored plan to support weight loss and overall health."
        }
        else if(bmi<39.9){
            commentConsidered.text = "Obesity (Class 2)"
            commentDescription.text = "With a BMI between 34.9 and 39.9, consult a healthcare provider for a comprehensive weight management plan. Emphasize portion control, a balanced diet, and regular exercise, aiming for both cardio and strength training. Consider medical supervision or surgical options based on individual needs and health conditions."
        }
        else{
            commentConsidered.text = "Obesity (Class 3)"
            commentDescription.text = "\n" +
                    "For a BMI over 40, seek immediate medical guidance. Weight loss surgery may be considered, but first, consult a healthcare professional to evaluate all options and create a personalized plan. Focus on a strict, calorie-controlled diet and supervised exercise to promote safe and significant weight loss."
        }










        reCalculateBtn.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
    }
}