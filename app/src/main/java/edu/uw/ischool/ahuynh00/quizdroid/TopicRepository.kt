package edu.uw.ischool.ahuynh00.quizdroid

interface TopicRepository {
    fun getAll(): List<Topic>
    fun delete(topic: Topic)
    fun insert(topic: Topic)
}