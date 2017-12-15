package com.example.psyche.reminder


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import java.util.*


public class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button1: Button = findViewById<Button>(R.id.goToday) as Button
        button1.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                val calendar: CalendarView = findViewById<Button>(R.id.calendarView) as CalendarView
                val today: Long = calendar.getDate()
                calendar.setDate(today)
            }
        })

        val button2: Button = findViewById<Button>(R.id.button2) as Button
        button2.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, Main2Activity::class.java)
                intent.putExtra("today", 100)
                startActivity(intent)
            }
        })

    }
}
