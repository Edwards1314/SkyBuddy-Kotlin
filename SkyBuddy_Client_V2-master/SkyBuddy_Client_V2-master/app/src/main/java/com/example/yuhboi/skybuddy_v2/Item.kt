package com.example.yuhboi.skybuddy_v2

class Item {
    var name: String = ""
    var price: Double = 0.toDouble()

    constructor() {}

    constructor(name: String) {
        this.name = name
        this.price = 0.0
    }

    constructor(name: String, price: Double) {
        this.name = name
        this.price = price
    }
}

