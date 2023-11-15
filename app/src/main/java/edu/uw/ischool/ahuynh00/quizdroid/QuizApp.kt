package edu.uw.ischool.ahuynh00.quizdroid

import android.util.JsonReader
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.io.InputStreamReader

class QuizApp : android.app.Application() {
    lateinit var topicRepository: TopicRepository
    override fun onCreate() {
        super.onCreate()
        Log.d("Quiz app", "creating app")

        val questionJsonFile = File("/data/data/edu.uw.ischool.ahuynh00.quizdroid/files", "questions.json")
        if (!questionJsonFile.exists()) {
            Log.d("quizapp", "file dne")
        } else {
            Log.d("quizapp", "exists")

            val topics : MutableList<Topic> = mutableListOf()
            val questionsReader = InputStreamReader(FileInputStream(questionJsonFile))
            questionsReader.use {
                val buffer = it.readText()
                val topicArray = JSONArray(buffer)

                (0 until topicArray.length()).forEach { topicIndex ->
                    val topicObj = topicArray.getJSONObject(topicIndex)
                    val title = topicObj.get("title")
                    val desc = topicObj.get("desc")
                    val questionArray = topicObj.get("questions")
                    val questions: MutableList<Quiz> = mutableListOf()

                    if (questionArray is JSONArray) {
                        for (questionIndex in 0 until questionArray.length()) {
                            val quiz = questionArray.get(questionIndex)
                            Log.d("quiz", quiz.toString())

                            if (quiz is JSONObject) {
                                val text = quiz.get("text").toString() ?: ""
                                var answerList : MutableList<String> = mutableListOf()
                                for (optionIndex in 0 until (quiz.get("answers") as JSONArray).length()) {
                                    answerList.add((quiz.get("answers") as JSONArray).get(optionIndex).toString())
                                }
                                Log.d("answers", answerList.toString())


                                val newQuiz = Quiz(text, answerList, quiz.get("answer").toString().toInt() - 1) // -1 to get 0 based index
                                Log.d("new quiz", newQuiz.toString())
                                questions.add(newQuiz)
                            }
                        }
                    }
                    topics.add(Topic(title.toString(), desc.toString(), questions))
                }
            }
            topicRepository = MockTopicRepository(topics)
        }
    }

}