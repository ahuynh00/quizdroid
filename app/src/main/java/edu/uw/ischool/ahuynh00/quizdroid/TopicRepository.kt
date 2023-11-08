package edu.uw.ischool.ahuynh00.quizdroid

interface TopicRepository {
    fun getAll(): List<Topic>
    fun deleteTopic(topic: Topic)
    fun insertTopic(topic: Topic)
    fun deleteQuiz(quiz: Quiz, topic: Topic)
    fun insertQuiz(quiz: Quiz, topic: Topic)
}