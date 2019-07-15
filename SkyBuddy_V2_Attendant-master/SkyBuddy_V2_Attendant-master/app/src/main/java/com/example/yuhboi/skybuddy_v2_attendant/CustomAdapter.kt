package com.example.yuhboi.skybuddy_v2_attendant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView

import com.google.android.gms.common.util.Strings

import java.util.ArrayList

import com.example.yuhboi.skybuddy_v2_attendant.IncomingActivity.Companion.itemNames
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase

class CustomAdapter(private val context: Context, list: ArrayList<String>) : BaseAdapter(), ListAdapter {
    internal var mDatabase = FirebaseDatabase.getInstance().getReference("users")

    private var list = ArrayList<String>()

    init {
        this.list = list
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(pos: Int): String {
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
        listItemText.text = list[position]

        //Handle buttons and add onClickListeners
        val rmvBtn = view.findViewById<View>(R.id.rmv_btn) as Button

        rmvBtn.setOnClickListener {
            //do something
            list.remove(getItem(position))
            //removeItem(position)
            notifyDataSetChanged()
        }

        return view
    }
//    fun removeItem(position: Int){
//        mDatabase.child(getItem(position)).removeValue()
//    }
}