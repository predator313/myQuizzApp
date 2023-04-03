package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuestionsActivity : AppCompatActivity() {
    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null
    private var tvOption1:TextView?=null
    private var tvOption2:TextView?=null
    private var tvOption3:TextView?=null
    private var tvOption4:TextView?=null
    private var btnSubmitQuestion:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        progressBar=findViewById(R.id.progressbar)
        tvProgress=findViewById(R.id.tvProgress)
        tvQuestion=findViewById(R.id.tvQuestions)
        ivImage=findViewById(R.id.iv_image)
        tvOption1=findViewById(R.id.option1)
        tvOption2=findViewById(R.id.option2)
        tvOption3=findViewById(R.id.option3)
        tvOption4=findViewById(R.id.option4)
        btnSubmitQuestion=findViewById(R.id.btnSubmitQuestion)
        val questionList=Constants.getQuestion()
        var currPos=1
        val question:Question=questionList[currPos-1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress=currPos
        tvProgress?.text="$currPos/${progressBar?.max}"
        tvQuestion?.text=question.Question
        tvOption1?.text=question.optionOne
        tvOption2?.text=question.optionTwo
        tvOption3?.text=question.optionThree
        tvOption4?.text=question.optionFour

    }
}