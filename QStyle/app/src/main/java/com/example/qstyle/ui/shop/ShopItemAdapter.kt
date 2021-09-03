package com.example.qstyle.ui.shop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.qstyle.R

class ShopItemAdapter(
    var context: Context,
    var imageList: IntArray,
    var titleList: List<String>,
    var descriptionList: List<String>) : RecyclerView.Adapter<ShopItemAdapter.ShopItemAdapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShopItemAdapter.ShopItemAdapterViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.shop_item,parent,false)
        return ShopItemAdapterViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ShopItemAdapter.ShopItemAdapterViewHolder,
        position: Int
    ) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = titleList?.size ?: 0

    inner class ShopItemAdapterViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bind(position: Int){
            val image = view.findViewById<ImageView>(R.id.shop_item_img)
            val title = view.findViewById<TextView>(R.id.item_title)
            val description = view.findViewById<TextView>(R.id.item_description)

            image.setImageResource(imageList[position])
            title.text = titleList[position]
            description.text = descriptionList[position]

        }

    }
}