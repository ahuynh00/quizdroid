package edu.uw.ischool.ahuynh00.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.window.OnBackInvokedDispatcher


class TopicOverview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)
        val quizTopic = intent.getStringExtra("selected topic")

        val description = findViewById<TextView>(R.id.topic_description)
        val totalQuestions = findViewById<TextView>(R.id.total_questions)
        val beginBtn = findViewById<Button>(R.id.begin_button)

        when (quizTopic) { //todo: replace with find (questionpage line 13)
            "Math" -> {
                description.text = mathQuiz.description
                totalQuestions.text = "${mathQuiz.questions.size.toString()} questions"
            } "Physics" -> {
                description.text = physicsQuiz.description;
                totalQuestions.text = "${physicsQuiz.questions.size.toString()} questions";
            } "Marvel Super Heroes" -> {
                description.text = marvel_super_heroesQuiz.description
                totalQuestions.text = "${marvel_super_heroesQuiz.questions.size.toString()} questions";
            } else -> description.text = "Quiz not found"
        }
        beginBtn.setOnClickListener {
            val questionIntent = Intent(this, QuestionPage::class.java)
            questionIntent.putExtra("quiz topic", quizTopic)
            startActivity(questionIntent)
        }

    }
}