package edu.uw.ischool.ahuynh00.quizdroid

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var topics: List<Topic> = mutableListOf()
    lateinit var topicsAdapter: ArrayAdapter<String>
    lateinit var preferencesBtn: Button

    // from android documentation:
    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        // network is available for use
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
        }

        // Network capabilities have changed for the network
        // TODO: Not needed????
//        override fun onCapabilitiesChanged(
//            network: Network,
//            networkCapabilities: NetworkCapabilities
//        ) {
//            super.onCapabilitiesChanged(network, networkCapabilities)
//            val unmetered = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
//
//            val onAirplaneMode = Settings.Global.getInt(
//                applicationContext.contentResolver,
//                Settings.Global.AIRPLANE_MODE_ON)
//            if (onAirplaneMode !== 0) {
//                Toast.makeText(applicationContext, "Airplane mode is on, please turn off and connect to internet for" +
//                        "to download quiz data", Toast.LENGTH_LONG).show()
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.System.canWrite(applicationContext)) {
//                    val settingsIntent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
//                    settingsIntent.data = Uri.parse("package:" + applicationContext.packageName)
//                    startActivity(settingsIntent)
//                }
//            } else {
//                Toast.makeText(applicationContext, "No internet connection, please connect to internet to download quiz data",
//                    Toast.LENGTH_LONG).show()
//            }
//        }

        // lost network connection
        override fun onLost(network: Network) {
            super.onLost(network)
            val onAirplaneMode = Settings.Global.getInt(
                applicationContext.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON)
            if (onAirplaneMode !== 0) {
                Toast.makeText(applicationContext, "Airplane mode is on, please turn off and connect to internet" +
                        " to download quiz data", Toast.LENGTH_LONG).show()
                val settingsIntent = Intent()
                settingsIntent.action = Settings.ACTION_AIRPLANE_MODE_SETTINGS
                startActivity(settingsIntent)
            } else {
                Toast.makeText(applicationContext, "No internet connection, please connect to internet to download quiz data",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.action_bar))
        supportActionBar?.setDisplayShowTitleEnabled(false);
        preferencesBtn = findViewById(R.id.preferencesBtn)
        preferencesBtn.setOnClickListener{
            val preferencesIntent = Intent(this@MainActivity, PreferencesActivity::class.java)
            startActivity(preferencesIntent)
        }

        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        }


        val quizApp = (application as QuizApp)
        val repository = quizApp.topicRepository
        topics = repository.getAll()
        topicsAdapter = ArrayAdapter(this, android.R.layout.activity_list_item,
            android.R.id.text1, topics.map{topic -> topic.title})


        var quizListView = findViewById<ListView>(R.id.topic_list_view)
        quizListView.adapter = topicsAdapter
        quizListView.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            Log.d("topic list", "${topics[position]}")
            val quizOverviewIntent = Intent(this, TopicOverview::class.java)
            quizOverviewIntent.putExtra("selected topic", topics[position].title)

            startActivity(quizOverviewIntent)
        }
    }
}






