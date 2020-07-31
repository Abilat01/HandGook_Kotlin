package com.example.handbook_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adapter(listArray: ArrayList<ListItem>, context: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvContent = view.findViewById<TextView>(R.id.tv_content)
        val im = view.findViewById<ImageView>(R.id.image_id)

        fun bind(ListItem:ListItem, context: Context){
            tvTitle.text = ListItem.titleText
            tvContent.text = ListItem.contextText
            im.setImageResource(ListItem.imege_id)
            itemView.setOnClickListener() {  }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inFlater = LayoutInflater.from(contextR)
        return ViewHolder(inFlater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    fun updateAdapter(listArray: List<ListItem>){
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }

}