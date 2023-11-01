package edu.uw.ischool.ahuynh00.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

data class Quiz(val name: String, val description: String, val questions: Array<Question>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Quiz

        if (description != other.description) return false
        if (!questions.contentEquals(other.questions)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = description.hashCode()
        result = 31 * result + questions.contentHashCode()
        return result
    }
}

data class Question(val prompt: String, val options: Array<String>, val answer: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (prompt != other.prompt) return false
        if (!options.contentEquals(other.options)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = prompt.hashCode()
        result = 31 * result + options.contentHashCode()
        return result
    }
}

val mathQuestions = arrayOf(
    Question("What is 2 + 2?", arrayOf("3", "4", "5", "6"),
        "4" ),
    Question("If i have 3 apples and eat one, how many apples do i have left?",
        arrayOf("0", "1", "2", "3"),
        "2")
)

val physicsQuestions = arrayOf(
    Question("What is the gravitational acceleration constant in m/s^2?",
        arrayOf("3.14", "5.67", "7.83", "9.81"),
        "9.81"),
    Question("How many seconds are there in a minute?", arrayOf("15", "30", "45", "60"),
        "60")
)

val marvel_super_heroesQuestions = arrayOf(
    Question("How many infinite stones are there?", arrayOf("6", "7", "8", "9"), "6"),
    Question("What does S.H.I.E.L.D. stand for?",
        arrayOf("Security Hope Insurance Empowerment Life Devoted",
        "Secure Hostile Intelligence Expert Life Division",
        "Superhuman Homeland Intelligence Enforcement and Logistics Division",
        "Security Homeland Intervention Enforcement and Logistics Division"),
        "Security Homeland Intervention Enforcement and Logistics Division")
)

val mathQuiz = Quiz("Math","Mathematics is an area of knowledge that includes the topics of numbers, formulas and related structures, shapes and the spaces in which they are contained", mathQuestions)
val physicsQuiz = Quiz("Physics","Physics is the natural science of matter, involving the study of matter, its fundamental constituents, its motion and behavior through space and time", physicsQuestions)
val marvel_super_heroesQuiz = Quiz("Marvel Super Heroes", "Marvel Comics is an American comic book publisher and the property of The Walt Disney Company since December 31, 2009", marvel_super_heroesQuestions)
val quizzes = arrayOf(mathQuiz, physicsQuiz, marvel_super_heroesQuiz)
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
            val quizOverviewIntent = Intent(this, TopicOverview::class.java)
            quizOverviewIntent.putExtra("selected topic", quizTopics[position])
            startActivity(quizOverviewIntent)
        }
    }
}