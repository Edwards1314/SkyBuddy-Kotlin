package com.example.yuhboi.skybuddy_v2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView

import java.util.ArrayList

import com.example.yuhboi.skybuddy_v2.MainActivity.Companion.cart
import com.example.yuhboi.skybuddy_v2.CartActivity.Companion.totalPrice
import com.example.yuhboi.skybuddy_v2.CartActivity.Companion.textView

class ShoppingCartCustomAdapter(var list: ArrayList<Item>, private val context: Context) : BaseAdapter(), ListAdapter {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(pos: Int): Any {
        return list[pos]
    }

    override fun getItemId(pos: Int): Long {
        return 0
        //just return 0 if your list items do not have an Id variable.
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView
        if (view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.shoppingcartcustomlayout, null)
        }

        //Handle TextView and display string from your list
        val listItemText = view!!.findViewById<View>(R.id.list_item_string) as TextView
        val price = view.findViewById<View>(R.id.price) as TextView
        listItemText.text = list[position].name
        price.text = "$" + java.lang.Double.toString(list[position].price)
        //Handle buttons and add onClickListeners
        val addBtn = view.findViewById<View>(R.id.add_btn) as Button

        addBtn.setOnClickListener {
            //do something
            val diff = list[position].price
            totalPrice -= diff
            textView!!.text = "Total: $" + java.lang.Double.toString(totalPrice)

            cart.removeItem(list[position])
            notifyDataSetChanged()
        }
        return view
    }
}