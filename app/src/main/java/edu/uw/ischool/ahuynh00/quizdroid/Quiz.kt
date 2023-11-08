package edu.uw.ischool.ahuynh00.quizdroid

data class Quiz(val questionText: String,
                val options: MutableList<String>,
                val answer: Int)
