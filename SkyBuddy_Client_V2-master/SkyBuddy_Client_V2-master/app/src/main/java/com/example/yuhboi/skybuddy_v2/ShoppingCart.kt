package com.example.yuhboi.skybuddy_v2

import java.util.ArrayList

class ShoppingCart {
    var Items: ArrayList<Item>

    val items: List<Item>
        get() = Items
    val size: Int
        get() = Items.size

    constructor() {
        Items = ArrayList()
    }

    constructor(item: Item) {
        Items = ArrayList()
        Items.add(item)
    }
// Commented out because it said it clashed with the declaration of var Items
// (said they did the same thing)
//    fun setItems(items: ArrayList<Item>) {
//        Items = items
//    }

    fun addItem(item: Item) {
        Items.add(item)
    }

    fun removeItem(item: Item) {
        Items.remove(item)
    }

    fun getItem(i: Int): Item {
        return Items[i]
    }

//    fun getItems(): ArrayList<Item> { return Items}
}