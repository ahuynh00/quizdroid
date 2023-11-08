package edu.uw.ischool.ahuynh00.quizdroid

import android.graphics.drawable.Drawable

data class Topic(val title: String,
                 val icon: Int,
                 val shortDescription: String,
                 val longDescription: String,
                 val questions: MutableList<Quiz>)
