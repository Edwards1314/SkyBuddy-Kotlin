package com.example.yuhboi.skybuddy_v2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drinkButton = findViewById<Button>(R.id.drink)
        val foodButton = findViewById<Button>(R.id.food)
        val amenityButton = findViewById<Button>(R.id.amenity)
        val cartButton = findViewById<Button>(R.id.shoppingcart)
        addListenerOnDrink(drinkButton)
        addListenerOnFood(foodButton)
        addListenerOnAmenity(amenityButton)
        addListenerOnShoppingCart(cartButton)
    }

    fun addListenerOnDrink(drinkButton: Button) {
        drinkButton.setOnClickListener {
            val editText = findViewById<View>(R.id.seatNumber) as EditText
            seatNumberText = editText.text.toString()
            seatNumberText += empty
            val drinkActivity = Intent(this@MainActivity, DrinkActivity::class.java)
            startActivity(drinkActivity)
        }
    }

    private fun addListenerOnFood(foodButton: Button) {
        foodButton.setOnClickListener {
            val editText = findViewById<View>(R.id.seatNumber) as EditText
            seatNumberText = editText.text.toString()
            seatNumberText += empty
            val foodActivity = Intent(this@MainActivity, FoodActivity::class.java)
            startActivity(foodActivity)
        }
    }

    private fun addListenerOnAmenity(amenityButton: Button) {
        amenityButton.setOnClickListener {
            val editText = findViewById<View>(R.id.seatNumber) as EditText
            seatNumberText = editText.text.toString()
            seatNumberText += empty
            val amenityActivity = Intent(this@MainActivity, AmenityActivity::class.java)
            startActivity(amenityActivity)
        }
    }

    private fun addListenerOnShoppingCart(cartButton: Button) {
        cartButton.setOnClickListener {
            val editText = findViewById<View>(R.id.seatNumber) as EditText
            seatNumberText = editText.text.toString()
            seatNumberText += empty
            val cartActivity = Intent(this@MainActivity, CartActivity::class.java)
            startActivity(cartActivity)
        }
    }

    companion object {
        var cart = ShoppingCart()
        var seatNumberText: String = ""
        var empty = ""
    }
}
