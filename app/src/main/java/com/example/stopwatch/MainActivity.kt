package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    lateinit var storp : Button
    lateinit var timer : Chronometer
    lateinit var reset : Button
    //classwide statice constant in Kotlin
    companion object{
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wirewidgets()
    }

    private fun wirewidgets() {
        storp = findViewById(R.id.Button_main_start)
        reset = findViewById(R.id.Button_main_reset)
        timer = findViewById(R.id.chronometer_main_stopwatch)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }
    override fun onRestart(): Unit {
        super.onRestart()
        Log.d(TAG, "onRestart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResum")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}