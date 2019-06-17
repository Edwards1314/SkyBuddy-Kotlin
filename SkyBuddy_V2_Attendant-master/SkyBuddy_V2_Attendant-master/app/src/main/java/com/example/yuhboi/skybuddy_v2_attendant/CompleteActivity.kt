package com.example.yuhboi.skybuddy_v2_attendant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

class CompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)
        val listView = findViewById<View>(R.id.listview) as ListView
    }
}
