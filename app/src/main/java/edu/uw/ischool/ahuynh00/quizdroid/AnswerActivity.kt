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
        val repository = (this.application as QuizApp).topicRepository
        val quizzes = repository.getAll()


        val correctAnswersCount = intent.getStringExtra("correct answers count")!!.toInt()
        val currentQuizName = intent.getStringExtra("quiz topic")
        val currentQuiz = quizzes.find{it.title == currentQuizName}!!
        val currentQuestion = intent.getStringExtra("current question index")!!
        val previousQuestionIndex = currentQuestion.toInt() - 1
        val userAnswer = intent.getStringExtra("user answer")
        val correctAnswerIndex = currentQuiz.questions[previousQuestionIndex].answer

        val userAnswerTextView = findViewById<TextView>(R.id.userAnswer)
        val correctAnswerTextView = findViewById<TextView>(R.id.correctAnswer)
        val totalCorrectTextView = findViewById<TextView>(R.id.totalCorrect)
        val nextFinishBtn = findViewById<Button>(R.id.nextFinishBtn)

        userAnswerTextView.text = "Your answer was: $userAnswer"
        correctAnswerTextView.text = "The correct answer is: ${currentQuiz.questions[previousQuestionIndex].options[correctAnswerIndex]}"
        totalCorrectTextView.text = "You have $correctAnswersCount out of ${currentQuiz.questions.size} correct"
        if (currentQuestion.toInt() >= currentQuiz.questions.size) {
            nextFinishBtn.text = "Finish"
            nextFinishBtn.setOnClickListener{
                Log.d("next fin btn", "fin pls")
                val homeIntent = Intent(this, MainActivity::class.java)
                startActivity(homeIntent)
                finish()
            }
        } else {
            nextFinishBtn.text = "Next"
            nextFinishBtn.setOnClickListener{
                Log.d("next btn", "$currentQuestion")
                val questionIntent = Intent(this, QuestionPage::class.java)
                questionIntent.putExtra("quiz topic", currentQuizName!!)
                questionIntent.putExtra("current question index", currentQuestion)
                questionIntent.putExtra("correct answers count", correctAnswersCount.toString())
                startActivity(questionIntent)
            }
        }
    }
}