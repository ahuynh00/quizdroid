package edu.uw.ischool.ahuynh00.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        if (findViewById<View?>(R.id.idFrameLayout) != null) {
            if (savedInstanceState != null) {
                return
            }
            // below line is to inflate our fragment.
            fragmentManager.beginTransaction().add(R.id.idFrameLayout, PreferencesFragment()).commit()
        }
    }
}