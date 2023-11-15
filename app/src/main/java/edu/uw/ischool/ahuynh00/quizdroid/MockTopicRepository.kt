package edu.uw.ischool.ahuynh00.quizdroid

import java.io.File


class MockTopicRepository(topicList : MutableList<Topic>) : TopicRepository {
//    val topics : MutableList<Topic> = mutableListOf(
//        Topic("Math",
//            "This is a math quiz",
//            mutableListOf(
//                Quiz("What is 2 + 2?", mutableListOf("3", "4", "5", "6"),
//                    1),
//                Quiz("If i have 3 apples and eat one, how many apples do i have left?",
//                    mutableListOf("0", "1", "2", "3"),
//                    2)
//            )
//        ),
//        Topic("Physics",
//            "This is a physics quiz",
//              mutableListOf(
//                Quiz("What is the gravitational acceleration constant in m/s^2?",
//                    mutableListOf("3.14", "5.67", "7.83", "9.81"),
//                    3),
//                Quiz("How many seconds are there in a minute?", mutableListOf("15", "30", "45", "60"),
//                    3)
//            )
//        ),
//        Topic("Marvel Super Heroes",
//            "This is a quiz about marvel super heroes",
//                   mutableListOf(
//                Quiz("How many infinite stones are there?", mutableListOf("6", "7", "8", "9"), 0),
//                Quiz("What does S.H.I.E.L.D. stand for?",
//                    mutableListOf("Security Hope Insurance Empowerment Life Devoted",
//                        "Secure Hostile Intelligence Expert Life Division",
//                        "Superhuman Homeland Intelligence Enforcement and Logistics Division",
//                        "Security Homeland Intervention Enforcement and Logistics Division"),
//                    3)
//            )
//        )
//    )
    val topics = topicList

    override fun getAll(): List<Topic> {
        return topics
    }

    override fun deleteTopic(topic: Topic) {
        topics.remove(topic)
    }

    override fun insertTopic(topic: Topic) {
        topics.add(topic)
    }

    override fun deleteQuiz(quiz: Quiz, topic: Topic) {
        topics.find{it == topic}?.questions?.remove(quiz)
    }

    override fun insertQuiz(quiz: Quiz, topic: Topic) {
        topics.find{it == topic}?.questions?.add(quiz)
    }
}

