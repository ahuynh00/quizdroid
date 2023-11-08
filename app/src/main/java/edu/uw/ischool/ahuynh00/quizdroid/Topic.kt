package edu.uw.ischool.ahuynh00.quizdroid

data class Topic(val title: String,
                 val shortDescription: String,
                 val longDescription: String,
                 val questions: List<Quiz>)
