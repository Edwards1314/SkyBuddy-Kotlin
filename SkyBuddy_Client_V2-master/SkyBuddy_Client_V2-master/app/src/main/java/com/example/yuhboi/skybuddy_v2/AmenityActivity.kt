package com.example.yuhboi.skybuddy_v2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView

import java.util.ArrayList

class AmenityActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amenity)
        val cartButton = findViewById<Button>(R.id.shoppingcart)
        //generate list
        val list = ArrayList<Item>()
        val item = Item("Blanket")
        val item1 = Item("Headphones")
        val item2 = Item("Pillow")
        val item3 = Item("Moist Towelette")
        list.add(item)
        list.add(item1)
        list.add(item3)
        list.add(item2)

        //instantiate custom adapter
        val adapter = CustomAdapter(list, this)
        addListenerOnShoppingCart(cartButton)
        //handle listview and assign adapter
        val listView = findViewById<View>(R.id.listview) as ListView
        listView.adapter = adapter
    }

    private fun addListenerOnShoppingCart(cartButton: Button) {
        cartButton.setOnClickListener {
            val cartActivity = Intent(this, CartActivity::class.java)
            startActivity(cartActivity)
        }
    }
}

