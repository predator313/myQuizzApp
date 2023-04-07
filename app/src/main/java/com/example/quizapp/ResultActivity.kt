package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val btnStartAgain=findViewById<Button>(R.id.btnStartAgain)
        val tvName=findViewById<TextView>(R.id.tvname)

        val tvScore=findViewById<TextView>(R.id.tvscore)
        val total_question=intent.getIntExtra(Constants.TotalQuestion,0)
        val correct_answer=intent.getIntExtra(Constants.Correct_Answer,0)
        tvName.text=intent.getStringExtra(Constants.UserName)
        tvScore.text="your total score is ${correct_answer.toString()+"/"+total_question.toString()}"


        btnStartAgain.setOnClickListener{

            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}