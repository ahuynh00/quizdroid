package edu.uw.ischool.ahuynh00.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter: ArrayAdapter<String>
        val quizTopics = arrayOf("Math", "Physics", "Marvel Super Heroes")

        var quizListView = findViewById<ListView>(R.id.topic_list_view)
        arrayAdapter = ArrayAdapter(this, android.R.layout.activity_list_item, android.R.id.text1, quizTopics)
        quizListView.adapter = arrayAdapter
        quizListView.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            val intent = Intent(this, TopicOverview::class.java)
            intent.putExtra("selected topic", quizTopics[position])
            startActivity(intent)
        }
    }
}