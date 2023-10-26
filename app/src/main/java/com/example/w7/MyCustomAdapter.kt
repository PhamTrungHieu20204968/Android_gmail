package com.example.w7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class MyCustomAdapter(val items: ArrayList<ItemModel>):BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var viewHolder: MyViewHolder
        var itemView: View
        if (p1 == null) {
            itemView = LayoutInflater.from(p2?.context)
                .inflate(R.layout.custom_item, p2, false)
            viewHolder = MyViewHolder()
            viewHolder.itemTitle = itemView.findViewById(R.id.item_title)
            viewHolder.mailTitle = itemView.findViewById(R.id.mail_title)
            viewHolder.itemAvatar = itemView.findViewById(R.id.item_avatar)
            viewHolder.itemDescription = itemView.findViewById(R.id.item_description)
            viewHolder.itemTime = itemView.findViewById(R.id.item_time)
            viewHolder.itemCheckbox = itemView.findViewById(R.id.item_checkbox)
            itemView.tag = viewHolder
        } else {
            itemView = p1
            viewHolder = itemView.tag as MyViewHolder
        }

        viewHolder.itemTitle.text = items[p0].title
        viewHolder.mailTitle.text = items[p0].mail_title
        viewHolder.itemAvatar.text = items[p0].title[0].toString().uppercase()
        viewHolder.itemDescription.text = items[p0].description
        viewHolder.itemTime.text = items[p0].time
        viewHolder.itemCheckbox.isChecked = items[p0].selected

        viewHolder.mailTitle.ellipsize = android.text.TextUtils.TruncateAt.END
        viewHolder.itemDescription.ellipsize = android.text.TextUtils.TruncateAt.END

        if (items[p0].selected){
            viewHolder.itemCheckbox.setButtonDrawable(android.R.drawable.btn_star_big_on)
        }else viewHolder.itemCheckbox.setButtonDrawable(android.R.drawable.btn_star_big_off)

        viewHolder.itemCheckbox.setOnClickListener {
            items[p0].selected = ! items[p0].selected
            if (items[p0].selected){
                viewHolder.itemCheckbox.setButtonDrawable(android.R.drawable.btn_star_big_on)
            }else viewHolder.itemCheckbox.setButtonDrawable(android.R.drawable.btn_star_big_off)
            notifyDataSetChanged()
        }

        return itemView
    }

}

class MyViewHolder {
    lateinit var itemTitle: TextView
    lateinit var mailTitle: TextView
    lateinit var itemAvatar: TextView
    lateinit var itemDescription: TextView
    lateinit var itemTime: TextView
    lateinit var itemCheckbox: CheckBox
}