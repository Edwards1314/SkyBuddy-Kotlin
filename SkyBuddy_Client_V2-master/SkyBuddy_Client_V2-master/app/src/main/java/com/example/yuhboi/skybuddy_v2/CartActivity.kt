package com.example.yuhboi.skybuddy_v2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import com.example.yuhboi.skybuddy_v2.MainActivity.Companion.cart
import com.example.yuhboi.skybuddy_v2.MainActivity.Companion.seatNumberText


class CartActivity : Activity() {
    //var textView: TextView = findViewById(R.id.list_item_string)


    internal var mDatabase = FirebaseDatabase.getInstance().getReference("users")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        printCart(cart)
    }

    fun printCart(cart: ShoppingCart) {
        totalPrice = 0.0
        val checkoutButton = findViewById<Button>(R.id.checkout)
        for (i in 0 until cart.size) {
            totalPrice += cart.getItem(i).price
        }
        val adapter = ShoppingCartCustomAdapter(cart.Items, this)
        addListenerOnCheckout(checkoutButton)
        val listView = findViewById<View>(R.id.listviewcart) as ListView
        textView = findViewById<View>(R.id.totalPriceText) as TextView
        listView.adapter = adapter
        textView!!.text = "Total: $" + java.lang.Double.toString(totalPrice)

    }

    private fun addListenerOnCheckout(checkoutButton: Button) {
        checkoutButton.setOnClickListener {
            write()
            val cartActivity = Intent(this@CartActivity, MainActivity::class.java)
            startActivity(cartActivity)
        }
    }

    private fun write() {
        val userID = mDatabase.push().key
        cart.Items
        System.out.println(seatNumberText)
        val user = User(seatNumberText, cart.Items)
        mDatabase.child(userID!!).setValue(user)
    }

    companion object {
        var totalPrice: Double = 0.0
        var textView: TextView? = null
    }

}