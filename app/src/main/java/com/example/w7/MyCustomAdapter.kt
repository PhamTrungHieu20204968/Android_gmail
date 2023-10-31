package com.example.w7

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class MyCustomAdapter(val items: ArrayList<ItemModel>) :
    RecyclerView.Adapter<MyCustomAdapter.RVItemViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyCustomAdapter.RVItemViewHolder {
        val itemView = LayoutInflater.from(p0.context)
            .inflate(R.layout.custom_item, p0, false)
        return RVItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RVItemViewHolder, p0: Int) {
        viewHolder.itemTitle.text = items[p0].title
        viewHolder.mailTitle.text = items[p0].mail_title
        viewHolder.itemAvatar.text = items[p0].title[0].toString().uppercase()
        viewHolder.itemDescription.text = items[p0].description
        viewHolder.itemTime.text = items[p0].time
        viewHolder.itemCheckbox.isChecked = items[p0].selected

        viewHolder.mailTitle.ellipsize = android.text.TextUtils.TruncateAt.END
        viewHolder.itemDescription.ellipsize = android.text.TextUtils.TruncateAt.END

        if (items[p0].selected) {
            viewHolder.itemCheckbox.setButtonDrawable(android.R.drawable.btn_star_big_on)
        } else viewHolder.itemCheckbox.setButtonDrawable(android.R.drawable.btn_star_big_off)

        viewHolder.itemCheckbox.setOnClickListener {
            items[p0].selected = !items[p0].selected
            if (items[p0].selected) {
                viewHolder.itemCheckbox.setButtonDrawable(android.R.drawable.btn_star_big_on)
            } else viewHolder.itemCheckbox.setButtonDrawable(android.R.drawable.btn_star_big_off)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RVItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView
        val mailTitle: TextView
        val itemAvatar: TextView
        val itemDescription: TextView
        val itemTime: TextView
        val itemCheckbox: CheckBox

        init {
            itemTitle = itemView.findViewById(R.id.item_title)
            mailTitle = itemView.findViewById(R.id.mail_title)
            itemAvatar = itemView.findViewById(R.id.item_avatar)
            itemDescription = itemView.findViewById(R.id.item_description)
            itemTime = itemView.findViewById(R.id.item_time)
            itemCheckbox = itemView.findViewById(R.id.item_checkbox)


        }
    }


}