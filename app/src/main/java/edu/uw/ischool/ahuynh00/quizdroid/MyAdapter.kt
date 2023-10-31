package edu.uw.ischool.ahuynh00.quizdroid

import android.app.Activity
import android.widget.ArrayAdapter

class MyAdapter(private val context: Activity,
                private val arrayList: ArrayList<String>)
    : ArrayAdapter<String>(context, R.layout.list_item) {
}