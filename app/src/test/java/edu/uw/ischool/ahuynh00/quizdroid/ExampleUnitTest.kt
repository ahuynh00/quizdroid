package edu.uw.ischool.ahuynh00.quizdroid

import android.util.Log
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var repository: TopicRepository

    @Before
    fun setUp() {
        repository = MockTopicRepository()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

//    Create some unit tests that test the Repository's ability to save/retrieve
//    Topics and Quizzes (2 pts)
    @Test fun repo_add_delete_topics() {
        assertNotNull(repository)
        val newTopic = Topic("Informatics", R.drawable.ic_android_black_24dp,
            "there are a few required classes", "The informatics major has a wide " +
                    "variety of course to choose from. This breadth means students have required classes to take from many" +
                    "different topics",
            mutableListOf(
                Quiz("what class is NOT a requirement for the informatics major?",
                    mutableListOf("cse 143" ,"info 200", "info 448", "info 490"), 2),
                Quiz("which of the following is NOT a subcategory of the informatics program?",
                    mutableListOf("people" ,"technology", "society", "law"), 3)
            ))


        repository.insertTopic(newTopic)
        val newTopics = repository.getAll()

        assertNotNull(newTopics.find {it == newTopic})
        assertEquals(newTopic, newTopics.find { it == newTopic })

        repository.deleteTopic(newTopic)
        assertNull(repository.getAll().find{it == newTopic})
    }

    @Test fun repo_add_delete_quizzes() {
        assertNotNull(repository)
        val newTopic = Topic("Informatics", R.drawable.ic_android_black_24dp,
            "there are a few required classes", "The informatics major has a wide " +
                    "variety of course to choose from. This breadth means students have required classes to take from many" +
                    "different topics",
            mutableListOf(
                Quiz("what class is NOT a requirement for the informatics major?",
                    mutableListOf("cse 143" ,"info 200", "info 448", "info 490"), 2)
            ))
        val newQuiz =  Quiz("which of the following is NOT a subcategory of the informatics program?",
            mutableListOf("people" ,"technology", "society", "law"), 3)

        repository.insertTopic(newTopic)
        repository.insertQuiz(newQuiz, newTopic)

        assertNotNull(repository.getAll().find{it == newTopic}?.questions?.find { it == newQuiz })
        assertEquals(newQuiz, repository.getAll().find{it == newTopic}?.questions?.find { it == newQuiz })

        repository.deleteQuiz(newQuiz, newTopic)
        assertNull(repository.getAll().find{it == newTopic}?.questions?.find { it == newQuiz })

    }


}