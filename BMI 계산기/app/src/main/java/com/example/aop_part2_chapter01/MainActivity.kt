package com.example.aop_part2_chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class  MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //nullable type인지 명시 필요-> ?
        val heightEditText : EditText = findViewById(R.id.heightEditText) //명시적으로 type 선
        val weightEditText = findViewById<EditText>(R.id.weightEditText) //findViewById가 EditText를 반환하면서 추론적으로 알려줌
        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            //Log.d("MainActivity", "ResultButton이 클릭되었습니다.")

            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show() //짧게만 표시
                return@setOnClickListener //어떤 함수에서 리턴할지를 명시
            }
            //이 아래로는 빈 값이 절대 올 수 없음.
            val height : Int = heightEditText.text.toString().toInt() //값 가져오기
            val weight : Int= weightEditText.text.toString().toInt()
            //Log.d("MainActivity", "height : $height weight : $weight")
            //https://developer.android.com/guide/components/intents-filter?hl=ko
            val intent= Intent(this, ResultActivity::class.java) //어디서 어디 activity로 넘어갈지 정의
            intent.putExtra("height",height)//intent에 값을 담기 위함
            intent.putExtra("weight", weight)

            startActivity(intent) //다음으로 ResultActivity 실행
        }
        //인터페이스를 람다 형식으로 치환하여 바로 사용 가능 (setOnClickListener 함수 안에서 일어나는 동작을 람다 함수 안에서 지정 가능
    }
}