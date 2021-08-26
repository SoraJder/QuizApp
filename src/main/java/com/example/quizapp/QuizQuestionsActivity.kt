package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOption :Int = 0
    private var mCorrectAnswers: Int =0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName=intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList=Constants.getQuestions()

        setQuestion()

        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        val btn_submit=findViewById<Button>(R.id.btn_summit)

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    private fun setQuestion()
    {

        val btn_submit=findViewById<Button>(R.id.btn_summit)

        val question =mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition==mQuestionsList!!.size){
            btn_submit.text="FINISH"
        }else{
            btn_submit.text="SUBMIT"
        }

        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress=mCurrentPosition

        val tv_progress=findViewById<TextView>(R.id.tv_progress)
        tv_progress.text="$mCurrentPosition" + "/"+progressBar.max

        val tv_question=findViewById<TextView>(R.id.tv_question)
        tv_question.text=question!!.question

        val iv_image=findViewById<ImageView>(R.id.iv_image)
        iv_image.setImageResource(question.image)

        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)

        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)

        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {

        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        val btn_submit=findViewById<Button>(R.id.btn_summit)

        when(v?.id){
            R.id.tv_option_one->{
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three->{
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four->{
                selectedOptionView(tv_option_four,4)
            }
            R.id.btn_summit->{
                if(mSelectedOption==0)
                {
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionsList!!.size->{
                            setQuestion()
                        }else ->{
                        val intent= Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                }else{
                    val question=mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOption){
                        answerView(mSelectedOption , R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.corect_option_border_bg)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        btn_submit.text="FINISH"
                    }else{
                        btn_submit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOption=0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){

        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)

        when(answer){
            1->{
                tv_option_one.background=ContextCompat.getDrawable(
                        this,drawableView)
            }
            2->{
                tv_option_two.background=ContextCompat.getDrawable(
                    this,drawableView)
            }
            3->{
                tv_option_three.background=ContextCompat.getDrawable(
                    this,drawableView)
            }
            4->{
                tv_option_four.background=ContextCompat.getDrawable(
                    this,drawableView)
            }

        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum :Int){
        defaultOptionsView()
        mSelectedOption=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD )
        tv.background=ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg)
    }
}