package com.example.psyche.reminder


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.goToday) as Button
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val calendar: CalendarView = findViewById<Button>(R.id.calendarView) as CalendarView
        val today: Long = calendar.getDate()
        calendar.setDate(today)
    }
}
