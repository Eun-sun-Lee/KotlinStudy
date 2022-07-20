package com.example.aop_part2_chapter01

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    //onCreate -> activity가 실행됐을 때 호출해주는 함수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result) //view 연결

        //intent 대신 getintent도 가능
        val height= intent.getIntExtra("height", 0) //height 값이 없을 경우 default 값 필요
        val weight=intent.getIntExtra("weight", 0)
        Log.d("ResultActivity", "height: $height, weight : $weight")

        val bmi = weight / (height / 100.0).pow(2.0) //double형이 pow 함수 가지고 있기 때문에 바로 사용 가능
        val resultText= when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val resultValueTextView=findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView=findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text= resultText

    }
}