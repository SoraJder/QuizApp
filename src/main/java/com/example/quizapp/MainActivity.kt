package com.example.quizapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start_app=findViewById<Button>(R.id.btn_start)
        btn_start_app.setOnClickListener {
            val et_name=findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.et_name)
            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this, "Plese enter your name",Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}