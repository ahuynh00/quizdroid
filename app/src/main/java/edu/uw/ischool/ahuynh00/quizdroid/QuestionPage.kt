package edu.uw.ischool.ahuynh00.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.iterator

class QuestionPage : AppCompatActivity() {
//    private var currentQuizName = intent.getStringExtra("quiz topic")
//    private val currentQuiz = quizzes.find{it.name == currentQuizName} // todo: check for null?

    private var currentQuestionIndex = 0
    private var correctAnswersCount = 0

    private lateinit var questionPrompt: TextView
    private lateinit var answerRadioGroup: RadioGroup
    private lateinit var submitBtn: Button

    private lateinit var currentQuizName: String
    private lateinit var currentQuiz: Quiz
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        currentQuizName = intent.getStringExtra("quiz topic")!!
        currentQuiz = quizzes.find{it.name == currentQuizName}!! // todo: check for null?

        questionPrompt = findViewById(R.id.question_prompt)
        questionPrompt.text = currentQuiz.questions[currentQuestionIndex].prompt
        answerRadioGroup = findViewById(R.id.answerRadioGroup)
        for (i in 0 until answerRadioGroup.childCount) {
            val radioBtn = answerRadioGroup.getChildAt(i) as RadioButton
            radioBtn.text = currentQuiz.questions[currentQuestionIndex].options[i]
            radioBtn.setOnClickListener{
                submitBtn.isEnabled = (answerRadioGroup.checkedRadioButtonId !== -1)
            }
        }
        submitBtn = findViewById(R.id.submitBtn)
        submitBtn.isEnabled = (answerRadioGroup.checkedRadioButtonId !== -1)

        submitBtn.setOnClickListener {
            val selectedVal = findViewById<RadioButton>(answerRadioGroup.checkedRadioButtonId).text.toString()
            checkAnswer(selectedVal)
            loadAnswerPage()
        }
    }

    private fun checkAnswer(selectedVal: String) {
        val question = currentQuiz!!.questions[currentQuestionIndex]
        if (selectedVal == question.answer) {
            correctAnswersCount++
        }
        currentQuestionIndex++
        Log.d("checkAnswer()", "correctanswers: $correctAnswersCount")
        Log.d("checkAnswer()", "currentQIndex: $currentQuestionIndex")
    }

    private fun loadAnswerPage() {
        Log.d("loadAnswerPage()", "loading answer page")
//        val answerIntent = Intent(this, AnswerActivity::class.java)
//        answerIntent.putExtra("correct answers count", correctAnswersCount)
//        answerIntent.putExtra("quiz topic", currentQuizName)
//        if (currentQuestionIndex < currentQuiz!!.questions.size) {
//            answerIntent.putExtra("current question index", currentQuestionIndex)
//        } else {
//            answerIntent.putExtra("current question index", -1)
//        }
//        startActivity(answerIntent)
    }
}