package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private var mcurrPos:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedPos:Int=0
    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null
    private var tvOption1:TextView?=null
    private var tvOption2:TextView?=null
    private var tvOption3:TextView?=null
    private var tvOption4:TextView?=null
    private var btnSubmitQuestion:Button?=null
    private var mUserName:String?=null
    private var mCorrectAnswer:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestions)
        ivImage = findViewById(R.id.iv_image)
        tvOption1 = findViewById(R.id.option1)
        tvOption2 = findViewById(R.id.option2)
        tvOption3 = findViewById(R.id.option3)
        tvOption4 = findViewById(R.id.option4)
        btnSubmitQuestion = findViewById(R.id.btnSubmitQuestion)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmitQuestion?.setOnClickListener(this)
        mQuestionList = Constants.getQuestion()
        mUserName=intent.getStringExtra(Constants.UserName)
        setQuestion()
        defaultOptionView()

    }

    private fun setQuestion() {
        defaultOptionView()

        val question: Question = mQuestionList!![mcurrPos - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mcurrPos
        tvProgress?.text = "$mcurrPos/${progressBar?.max}"
        tvQuestion?.text = question.Question
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour
        if(mcurrPos==mQuestionList!!.size){
            btnSubmitQuestion?.text="Finish"
        }
        else{
            btnSubmitQuestion?.text="Next"
        }
    }
    private fun defaultOptionView(){
        val option=ArrayList<TextView>()
        tvOption1?.let {
            option.add(0,it)
        }
        tvOption2?.let {
            option.add(1,it)
        }
        tvOption3?.let {
            option.add(2,it)
        }
        tvOption4?.let {
            option.add(3,it)
        }
        for(op in option){
            op.setTextColor(Color.parseColor("#7A8389"))
            op.typeface= Typeface.DEFAULT
            op.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_bg
            )
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOption:Int){
        defaultOptionView()
        mSelectedPos=selectedOption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1 ->{
                tvOption1?.let {
                    selectedOptionView(it,1)
                }
            } R.id.option2 ->{
                tvOption2?.let {
                    selectedOptionView(it,2)
                }
            } R.id.option3 ->{
                tvOption3?.let {
                    selectedOptionView(it,3)
                }
            } R.id.option4 ->{
                tvOption4?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btnSubmitQuestion ->{
                if(mSelectedPos==0){
                    mcurrPos++
                    when{mcurrPos<=mQuestionList!!.size ->{
                        setQuestion()
                    }
                        else ->{
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.UserName,mUserName)
                            intent.putExtra(Constants.Correct_Answer,mCorrectAnswer)
                            intent.putExtra(Constants.TotalQuestion,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question=mQuestionList?.get(mcurrPos-1)
                    if(question!!.correctAnswer!=mSelectedPos){
                        answerView(mSelectedPos,R.drawable.wrong_option_bg)
                    }
                    else mCorrectAnswer++
                    answerView(question.correctAnswer,R.drawable.correct_option_bg)
                    if(mcurrPos==mQuestionList!!.size){
                        btnSubmitQuestion?.text="Finish"
//                        val intent=Intent(this,ResultActivity::class.java)
//                        intent.putExtra(Constants.UserName,mUserName)
//                        startActivity(intent)
//                        finish()
                    }
                    else{
                        btnSubmitQuestion?.text="Next Question"
                    }
                    mSelectedPos=0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1 ->{
                tvOption1?.background=ContextCompat.getDrawable(this,drawableView)
            }2 ->{
                tvOption2?.background=ContextCompat.getDrawable(this,drawableView)
            }3 ->{
                tvOption3?.background=ContextCompat.getDrawable(this,drawableView)
            }4 ->{
                tvOption4?.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}