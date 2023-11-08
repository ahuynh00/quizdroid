package edu.uw.ischool.ahuynh00.quizdroid

import android.util.Log

class QuizApp : android.app.Application() {
    lateinit var topicRepository: TopicRepository
    override fun onCreate() {
        super.onCreate()
        Log.d("Quiz app", "creating app")

        topicRepository = MockTopicRepository(); // for now
    }
}