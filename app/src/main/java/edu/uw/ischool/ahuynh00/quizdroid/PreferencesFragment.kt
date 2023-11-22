package edu.uw.ischool.ahuynh00.quizdroid
import android.os.Bundle
import android.preference.PreferenceFragment


class PreferencesFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
    }
}