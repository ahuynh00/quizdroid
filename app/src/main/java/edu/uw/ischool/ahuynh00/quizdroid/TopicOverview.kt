package edu.uw.ischool.ahuynh00.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class TopicOverview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)
        val quizTopic = intent.getStringExtra("selected topic")!!
        val repository = (this.application as QuizApp).topicRepository


        val description = findViewById<TextView>(R.id.topic_description)
        val totalQuestions = findViewById<TextView>(R.id.total_questions)
        val beginBtn = findViewById<Button>(R.id.begin_button)

        val selectedQuiz = repository.getAll().find { it.title == quizTopic }
        description.text = selectedQuiz?.desc
        totalQuestions.text = "${selectedQuiz?.questions?.size.toString()} questions"

        beginBtn.setOnClickListener {
            val questionIntent = Intent(this, QuestionPage::class.java)
            questionIntent.putExtra("quiz topic", quizTopic)
            startActivity(questionIntent)
        }

    }
}

