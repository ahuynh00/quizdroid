package edu.uw.ischool.ahuynh00.quizdroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

data class Topic(val title: String,
                 val shortDescription: String,
                 val longDescription: String,
                 val questions: List<Quiz>)
data class Quiz(val questionText: String,
                val options: List<String>,
                val answer: Int)

class MainActivity : AppCompatActivity() {
    var topics: List<Topic> = mutableListOf()
    lateinit var topicsAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quizApp = (application as QuizApp)
        val repository = quizApp.topicRepository
        topics = repository.getAll()
        topicsAdapter = ArrayAdapter(this, android.R.layout.activity_list_item,
            android.R.id.text1, topics.map{topic -> topic.title})


        var quizListView = findViewById<ListView>(R.id.topic_list_view)
        quizListView.adapter = topicsAdapter
        quizListView.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            Log.d("topic list", "${topics[position]}")
            val quizOverviewIntent = Intent(this, TopicOverview::class.java)
            quizOverviewIntent.putExtra("selected topic", topics[position].title)

            startActivity(quizOverviewIntent)
        }
    }
}






