package edu.uw.ischool.ahuynh00.quizdroid


class MockTopicRepository: TopicRepository {
    val topics : MutableList<Topic> = mutableListOf(
        Topic("Math",
            "This is a math quiz",
            "Mathematics is an area of knowledge that includes the topics of numbers," +
                    " formulas and related structures, shapes and the spaces in which they are contained",
            listOf(
                Quiz("What is 2 + 2?", listOf("3", "4", "5", "6"),
                    1),
                Quiz("If i have 3 apples and eat one, how many apples do i have left?",
                    listOf("0", "1", "2", "3"),
                    2)
            )
        ),
        Topic("Physics",
            "This is a physics quiz",
            "Physics is the natural science of matter, involving the study of matter," +
                    " its fundamental constituents, its motion and behavior through space and time",
            listOf(
                Quiz("What is the gravitational acceleration constant in m/s^2?",
                    listOf("3.14", "5.67", "7.83", "9.81"),
                    3),
                Quiz("How many seconds are there in a minute?", listOf("15", "30", "45", "60"),
                    3)
            )
        ),
        Topic("Marvel Super Heroes",
            "This is a quiz about marvel super heroes",
            "Marvel Comics is an American comic book publisher and the property of The " +
                    "Walt Disney Company since December 31, 2009",
            listOf(
                Quiz("How many infinite stones are there?", listOf("6", "7", "8", "9"), 0),
                Quiz("What does S.H.I.E.L.D. stand for?",
                    listOf("Security Hope Insurance Empowerment Life Devoted",
                        "Secure Hostile Intelligence Expert Life Division",
                        "Superhuman Homeland Intelligence Enforcement and Logistics Division",
                        "Security Homeland Intervention Enforcement and Logistics Division"),
                    3)
            )
        )
    )
    override fun getAll(): List<Topic> {
        return topics
    }

    override fun delete(topic: Topic) {
        topics.remove(topic)
    }

    override fun insert(topic: Topic) {
        topics.add(topic)
    }
}

