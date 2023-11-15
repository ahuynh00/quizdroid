package edu.uw.ischool.ahuynh00.quizdroid

data class Quiz(val text: String,
                val answers: MutableList<String>,
//                val answers : Array<String>,
                val answer: Int)
