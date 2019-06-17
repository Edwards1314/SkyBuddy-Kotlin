package com.example.yuhboi.skybuddy_v2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView

import java.util.ArrayList

class FoodActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val cartButton = findViewById<Button>(R.id.shoppingcart)
        //generate list
        val list = ArrayList<Item>()
        val item = Item("Muffin", 2.2)
        val item1 = Item("Pasta", .5)
        val item2 = Item("Pretzels", .75)
        val item3 = Item("Peanuts", 1.0)
        list.add(item)
        list.add(item1)
        list.add(item2)
        list.add(item3)

        //instantiate custom adapter
        val adapter = CustomAdapter(list, this)
        addListenerOnShoppingCart(cartButton)
        //handle listview and assign adapter
        val listView = findViewById<View>(R.id.listview) as ListView
        listView.adapter = adapter
    }

    private fun addListenerOnShoppingCart(cartButton: Button) {
        cartButton.setOnClickListener {
            val cartActivity = Intent(this@FoodActivity, CartActivity::class.java)
            startActivity(cartActivity)
        }
    }
}

