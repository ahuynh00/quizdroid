package edu.uw.ischool.ahuynh00.quizdroid

import android.graphics.drawable.Drawable

data class Topic(val title: String,
                 val desc: String,
                 val questions: MutableList<Quiz>)
