package com.example.yuhboi.skybuddy_v2_attendant

class Item {
    var name: String? = null
    var price: Double? = null

    constructor() {}

    constructor(name: String) {
        this.name = name
        this.price = -1.0
    }

    constructor(name: String, price: Double?) {
        this.name = name
        this.price = price
    }
}

