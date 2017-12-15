package com.example.psyche.reminder


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, CalendarView.OnDateChangeListener {
    val sm = ScheduleManager()
    var year: Int = 1970
    var month: Int = 1
    var day: Int = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.goToday)
        button.setOnClickListener(this)

        val calendar: CalendarView = findViewById(R.id.calendarView)
        calendar.setOnDateChangeListener(this)

        val registerScheduleButton: Button = findViewById(R.id.registerScheduleButton)
        registerScheduleButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.goToday -> {
                val calendar: CalendarView = findViewById(R.id.calendarView)
                val today: Long = calendar.getDate()
                calendar.setDate(today)
            }
            R.id.registerScheduleButton -> {
                val scheduleTitle: EditText = findViewById(R.id.scheduleTitle)
                val title: String = scheduleTitle.getText().toString()
                sm.setSchedule(title, year, month, day)
            }
        }

    }

    override fun onSelectedDayChange(p0: CalendarView?, p1: Int, p2: Int, p3: Int) {
        val textDate: TextView = findViewById(R.id.date)
        textDate.setText(""+p1+"年"+(p2+1)+"月"+p3+ "日")

        scheduleTitle.setText(sm.getScheduleTitle(p1,p2,p3))
        year = p1
        month = p2
        day = p3
    }
}
