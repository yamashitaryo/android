package com.example.psyche.reminder

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import java.text.SimpleDateFormat


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val today = intent.getLongExtra("today", 1)
        val cal = Calendar.getInstance()
        cal.setTimeInMillis(today)
        val sdf = SimpleDateFormat("yyyy/MM/dd")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val dateText: EditText = findViewById<EditText>(R.id.dateText) as EditText
        dateText.setText(sdf.format(cal.getTime()))
        val button: Button = findViewById<Button>(R.id.submitButton) as Button
        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                val dateText: EditText = findViewById<EditText>(R.id.dateText) as EditText
                val timeText: EditText = findViewById<EditText>(R.id.timeText) as EditText
                val titleText: EditText = findViewById<EditText>(R.id.titleText) as EditText
                val prefer: SharedPreferences = getSharedPreferences("schedule", Context.MODE_PRIVATE)
                val intent = Intent(this@Main2Activity, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
