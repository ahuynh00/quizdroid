package edu.uw.ischool.ahuynh00.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val correctAnswersCount = intent.getStringExtra("correct answers count")!!.toInt()
        val currentQuizName = intent.getStringExtra("quiz topic")
        val currentQuiz = quizzes.find{it.name == currentQuizName}!!
        val currentQuestion = intent.getStringExtra("current question index")!!
        val previousQuestionIndex = currentQuestion.toInt() - 1
//        = if (currentQuestion == "-1") {
//            currentQuiz.questions.size - 1
//        } else {
//            currentQuestion!!.toInt() - 1
//        }
        val userAnswer = intent.getStringExtra("user answer")

        val userAnswerTextView = findViewById<TextView>(R.id.userAnswer)
        val correctAnswerTextView = findViewById<TextView>(R.id.correctAnswer)
        val totalCorrectTextView = findViewById<TextView>(R.id.totalCorrect)
        val nextFinishBtn = findViewById<Button>(R.id.nextFinishBtn)

        userAnswerTextView.text = "Your answer was: $userAnswer"
        correctAnswerTextView.text = "The correct answer is: ${currentQuiz.questions[previousQuestionIndex].answer}"
        totalCorrectTextView.text = "You have $correctAnswersCount out of ${currentQuiz.questions.size} correct"
        if (currentQuestion !== "-1") {
            nextFinishBtn.text = "Next"
            nextFinishBtn.setOnClickListener{
                Log.d("next btn", "$currentQuestion")
                val questionIntent = Intent(this, QuestionPage::class.java)
                questionIntent.putExtra("quiz topic", currentQuizName!!)
                questionIntent.putExtra("current question index", currentQuestion)
                questionIntent.putExtra("correct answers count", correctAnswersCount.toString())
                startActivity(questionIntent)
            }
        } else {
            nextFinishBtn.text = "Finish"
            //todo make route to home
            nextFinishBtn.setOnClickListener{
                Log.d("next fin btn", "fin pls")
            }
        }
    }
}