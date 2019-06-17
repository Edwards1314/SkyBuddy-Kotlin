package com.example.yuhboi.skybuddy_v2_attendant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import java.util.ArrayList

class IncomingActivity : AppCompatActivity() {
    internal var mDatabase = FirebaseDatabase.getInstance().getReference("users")
    private var seatNumber: String? = null
    private var order = ""
    private val name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incoming)
        read()
        //generate list
        //instantiate custom adapter
        val adapter = CustomAdapter(this, list)
        //handle listview and assign adapter
        val listView = findViewById<View>(R.id.listview) as ListView
        listView.adapter = adapter
    }

    private fun read() {
        mDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (messageSnapshot in dataSnapshot.children) {
                    var temp = ""
                    order = ""
                    println("SN: " + messageSnapshot.child("seatNumber").value!!)
                    println("SHOPPING: " + messageSnapshot.child("shoppingCart").value!!)
                    seatNumber = messageSnapshot.child("seatNumber").value!!.toString()
                    for (newSnapshot in messageSnapshot.child("shoppingCart").children) {
                        if (!newSnapshot.exists()) {
                            temp = newSnapshot.child("name").value!!.toString()
                            order += temp + "\n"
                            println("ORDER IN LOOP: $order")
                        }
                    }
                    order = "$seatNumber:\n$order"
                    println("ORDER AFTER LOOP: $order")
                    list.add(order)
                }
                println(list.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                //handle databaseError
            }
        })
    }

    companion object {
        var itemNames = ArrayList<String>()
        var list = ArrayList<String>()
    }
}

