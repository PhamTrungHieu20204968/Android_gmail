package com.example.w7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Prepare arrays of data
        val itemList = arrayListOf<ItemModel>()
        for (i in 1..24) {
            itemList.add(ItemModel(('a' + i-1).toString() + "@gmail.com","Example title Example titleExample titleExample titleExample title",
                "Example description Example description Example description Example description",if (i <= 12) "$i:00 AM" else "${i-12}:00 PM"))
        }
        val adapter = MyCustomAdapter(itemList)
        val rcView : RecyclerView = findViewById(R.id.RVLayout)
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = adapter
    }
}