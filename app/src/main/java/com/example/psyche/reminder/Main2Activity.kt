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
import org.w3c.dom.Text
import java.util.*
import java.text.SimpleDateFormat


class Main2Activity : AppCompatActivity() ,View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button: Button = findViewById(R.id.submitButton)
        button.setOnClickListener(this)

        val today = intent.getStringExtra("today")
        val dateText: TextView = findViewById(R.id.selectedDateTextView)
        dateText.setText(today)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submitButton -> {
                val prefer: SharedPreferences = getSharedPreferences("schedule", Context.MODE_PRIVATE)
                val intent = Intent(this@Main2Activity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
