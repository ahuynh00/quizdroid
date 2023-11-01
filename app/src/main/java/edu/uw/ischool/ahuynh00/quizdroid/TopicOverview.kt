package edu.uw.ischool.ahuynh00.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView





class TopicOverview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)
        val quizTopic = intent.getStringExtra("selected topic")

        val description = findViewById<TextView>(R.id.topic_description)
        val totalQuestions = findViewById<TextView>(R.id.total_questions)
        val beginBtn = findViewById<Button>(R.id.begin_button)

        when (quizTopic) { //another way to do this?
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
            // set intent and adapter stuff here
        }

    }
}