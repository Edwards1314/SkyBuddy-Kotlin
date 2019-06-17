package com.example.yuhboi.skybuddy_v2_attendant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val incomingButton = findViewById<Button>(R.id.incoming)
        val completeButton = findViewById<Button>(R.id.complete)
        addListenerOnIncoming(incomingButton)
        addListenerOnComplete(completeButton)
    }

    private fun addListenerOnIncoming(incomingButton: Button) {
        incomingButton.setOnClickListener {
            val incomingActivity = Intent(this, IncomingActivity::class.java)
            startActivity(incomingActivity)
        }
    }

    private fun addListenerOnComplete(completeButton: Button) {
        completeButton.setOnClickListener {
            val completeActivity = Intent(this, CompleteActivity::class.java)
            startActivity(completeActivity)
        }
    }
}
