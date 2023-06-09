package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart=findViewById<Button>(R.id.btnStart)
        val name=findViewById<EditText>(R.id.name)
        btnStart.setOnClickListener {
            if(name.text.isNotEmpty()){
                val intent=Intent(this,QuestionsActivity::class.java)
                intent.putExtra(Constants.UserName,name.text.toString())
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"please enter your name",Toast.LENGTH_LONG).show()
            }
        }
    }
}