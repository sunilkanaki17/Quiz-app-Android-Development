package com.example.flagmaster

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.flagmaster.constants.correctanswers

class questionslistActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition = 1
    private var questionlist: ArrayList<questions>? = null

    private var mselectedoptionposition: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvquestion: TextView? = null
    private var tvprogress: TextView? = null
    private var ivimage: ImageView? = null

    private var tvoptionone: TextView? = null
    private var tvoptiontwo: TextView? = null
    private var tvoptionthree: TextView? = null
    private var tvoptionfour: TextView? = null
    private var buttonsubmit: Button? = null


    private var musername :String? =null
    private var correctans : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionslist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        musername = intent.getStringExtra("username")
        progressBar = findViewById(R.id.p_bar)
        tvquestion = findViewById(R.id.tvquestions)
        tvprogress = findViewById(R.id.p_text)
        ivimage = findViewById(R.id.ivimages)
        tvoptionone = findViewById(R.id.tvoptionsone)
        tvoptiontwo = findViewById(R.id.tvoptionstwo)
        tvoptionthree = findViewById(R.id.tvoptionsthree)
        tvoptionfour = findViewById(R.id.tvoptionsfour)
        buttonsubmit = findViewById(R.id.btn_submit)

        questionlist = constants.getquestions()

        setquestions()

        tvoptionone?.setOnClickListener(this)
        tvoptiontwo?.setOnClickListener(this)
        tvoptionthree?.setOnClickListener(this)
        tvoptionfour?.setOnClickListener(this)
        buttonsubmit?.setOnClickListener(this)
    }

    private fun setquestions() {
        val question: questions = questionlist!![mCurrentPosition - 1]
        ivimage?.setImageResource(question.img)
        progressBar?.progress = mCurrentPosition
        tvprogress?.text = "${mCurrentPosition}/${progressBar?.max}"
        tvquestion?.text = question.question
        tvoptionone?.text = question.optionOne
        tvoptiontwo?.text = question.optionTwo
        tvoptionthree?.text = question.optionThree
        tvoptionfour?.text = question.optionFour
        defaultOptionsView()
        buttonsubmit?.text = "Submit"
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        tvoptionone?.let { options.add(it) }
        tvoptiontwo?.let { options.add(it) }
        tvoptionthree?.let { options.add(it) }
        tvoptionfour?.let { options.add(it) }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mselectedoptionposition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#7A8089"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvoptionsone -> {
                tvoptionone?.let { selectedOptionView(it, 1) }
            }
            R.id.tvoptionstwo -> {
                tvoptiontwo?.let { selectedOptionView(it, 2) }
            }
            R.id.tvoptionsthree -> {
                tvoptionthree?.let { selectedOptionView(it, 3) }
            }
            R.id.tvoptionsfour -> {
                tvoptionfour?.let { selectedOptionView(it, 4) }
            }
            R.id.btn_submit -> {
                if (mselectedoptionposition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= questionlist!!.size -> {
                            setquestions()
                        }
                        else -> {
                            val intent = Intent(this, result_activity::class.java)
                            intent.putExtra("username",musername)
                            intent.putExtra("correctanswers",correctans)
                            intent.putExtra("total_questions",questionlist?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = questionlist?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mselectedoptionposition) {
                        answerview(mselectedoptionposition, R.drawable.wrong_option_bg)
                    }else{
                        correctans++;
                    }
                        answerview(question.correctAnswer, R.drawable.correct_option_bg)


                    if (mCurrentPosition == questionlist!!.size) {
                        buttonsubmit?.text = "Finish"
                    } else {
                        buttonsubmit?.text = "Go to next question"
                    }

                    mselectedoptionposition = 0
                }
            }
        }
    }

    private fun answerview(answer: Int?, drawable: Int) {

        val textcolor:Int = when (drawable){
            R.drawable.correct_option_bg -> Color.parseColor("#000000")
            R.drawable.wrong_option_bg -> Color.parseColor("#000000")
            else -> Color.parseColor("#798089")
        }
        when (answer) {
            1 -> {
                tvoptionone?.background = ContextCompat.getDrawable(this, drawable)
                tvoptionone?.setTextColor(textcolor)
            }
            2 -> {
                tvoptiontwo?.background = ContextCompat.getDrawable(this, drawable)
                tvoptiontwo?.setTextColor(textcolor)
            }
            3 -> {
                tvoptionthree?.background = ContextCompat.getDrawable(this, drawable)
                tvoptionthree?.setTextColor(textcolor)
            }
            4 -> {
                tvoptionfour?.background = ContextCompat.getDrawable(this, drawable)
                tvoptionfour?.setTextColor(textcolor)
            }
        }
    }
}
