package com.example.psyche.reminder

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class Main2Activity : AppCompatActivity() ,View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button: Button = findViewById(R.id.submitButton)
        button.setOnClickListener(this)

        val today = intent.getStringExtra("todayText")
        val dateText: TextView = findViewById(R.id.selectedDateTextView)
        dateText.setText(today)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submitButton -> {
                val hourText: EditText = findViewById(R.id.hourText)
                val minuteText: EditText = findViewById(R.id.minuteText)
                val titleText: EditText = findViewById(R.id.titleText)

                val year = intent.getIntExtra("year", 1970)
                val month = intent.getIntExtra("month", 1)
                val day = intent.getIntExtra("day", 1)
                val hour = hourText.text
                val minute = minuteText.text
                val title = titleText.text.toString()
                /*このyear,month,day,hour,minute,titleからなるスケジュールのデータを保存したい*/

                val prefer: SharedPreferences = getSharedPreferences("schedule", Context.MODE_PRIVATE)
                val intent = Intent(this@Main2Activity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
