package com.example.psyche.reminder


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
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

        val cal = Calendar.getInstance()
        year = cal.get(Calendar.YEAR)
        month = cal.get(Calendar.MONTH)
        day = cal.get(Calendar.DATE)

        val scheduleView: TextView = findViewById(R.id.scheduleView)
        scheduleView.setText(""+year+"年"+(month+1)+"月"+day+ "日")
        scheduleView.append("\n予定なし")
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.goToday -> {
                val calendar: CalendarView = findViewById(R.id.calendarView)
                val today: Long = calendar.getDate()
                calendar.setDate(today)
            }
            R.id.registerScheduleButton -> {
                val intent = Intent(this@MainActivity, Main2Activity::class.java)
                intent.putExtra("todayText", ""+year+"年"+(month+1)+"月"+day+ "日")
                intent.putExtra("year", year)
                intent.putExtra("month", month)
                intent.putExtra("day", day)
                startActivity(intent)
            }
        }
    }

    override fun onSelectedDayChange(p0: CalendarView?, p1: Int, p2: Int, p3: Int) {
        val scheduleView: TextView = findViewById(R.id.scheduleView)
        scheduleView.setText(""+p1+"年"+(p2+1)+"月"+p3+ "日")
        scheduleView.append("\n予定なし")

        year = p1
        month = p2
        day = p3
    }
}
