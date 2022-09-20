package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private lateinit var storp : Button
    private lateinit var timer : Chronometer
    private lateinit var reset : Button
    var isrunnning = false
    var stopTime=0L
    //classwide statice constant in Kotlin
    companion object{
        val TAG = "MainActivity"
        val STATE_TIME = "display time"
        val ISRUNNING = "is running"
        val BASE = "timer base"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wirewidgets()
        if(savedInstanceState!=null){
            isrunnning = savedInstanceState.getBoolean(ISRUNNING)
            timer.base = savedInstanceState.getLong(BASE)
            stopTime = savedInstanceState.getLong(STATE_TIME)
            //if(!isrunnning)
//            timer.base = SystemClock.elapsedRealtime()-(stopTime-timer.base)
        }
        if(savedInstanceState==null) {
            stopstart()
            stopstart()
        }
        storp.setOnClickListener {
            stopstart()
        }
        reset.setOnClickListener {
            timer.setBase(SystemClock.elapsedRealtime())
            if(storp.text=="start")
                isrunnning = !isrunnning
            stopstart()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if(!isrunnning)
        stopTime = SystemClock.elapsedRealtime()
        outState.putLong(BASE, timer.base)
        outState.putLong(STATE_TIME, stopTime)
        outState.putBoolean(ISRUNNING, isrunnning)
        super.onSaveInstanceState(outState)

    }

    private fun stopstart() {
        if(!isrunnning){
            if(stopTime!=0L)
                timer.base = SystemClock.elapsedRealtime()-(stopTime-timer.base)
            timer.start()
            storp.text="stop"

        }
        else{
            timer.stop()
            storp.text="start"
            stopTime=SystemClock.elapsedRealtime()

        }
        isrunnning = !isrunnning
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