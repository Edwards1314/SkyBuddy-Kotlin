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

class CustomAdapter(var list: ArrayList<Item>, var context: Context) : BaseAdapter(), ListAdapter {

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
            view = inflater.inflate(R.layout.custom_layout, null)
        }

        //Handle TextView and display string from your list
        val listItemText = view!!.findViewById<View>(R.id.list_item_string) as TextView
        listItemText.text = list[position].name

        //Handle buttons and add onClickListeners
        val addBtn = view.findViewById<View>(R.id.add_btn) as Button

        addBtn.setOnClickListener {
            //do something
            notifyDataSetChanged()
            cart.addItem(list[position])
        }

        return view
    }
}