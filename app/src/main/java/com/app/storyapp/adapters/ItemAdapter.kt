package com.app.storyapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.storyapp.Details
import com.app.storyapp.R
import com.squareup.picasso.Picasso

class ItemAdapter(
    val context:Context,
    val storyTitles:Array<String>,
    val storyContent:Array<String>,
    val storyImages:Array<String>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val cardTitle:TextView = itemView.findViewById(R.id.cardTitle)
        val cardContent:TextView = itemView.findViewById(R.id.cardContent)
        val cardImage:ImageView = itemView.findViewById(R.id.cardImage)
        val view = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_item_view,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return storyTitles.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.cardTitle.text = storyTitles[position]
        holder.cardContent.text = storyContent[position]
        Picasso.get().load(storyImages[position]).into(holder.cardImage);

        holder.view.setOnClickListener{
            val intent = Intent(it.context,Details::class.java)
            intent.putExtra("storyTitle",storyTitles[position])
            intent.putExtra("storyContent",storyContent[position])
            intent.putExtra("storyImage",storyImages[position])
            holder.view.context.startActivity(intent)
        }
    }
}