package com.example.androidrecyclerview.service

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrecyclerview.R
import com.example.androidrecyclerview.model.Clothes

class ClothesAdapter(
    private val clothes: ArrayList<Clothes>,
) : RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder>() {
    private var onClothesClickListener: OnClothesClickListener? = null

    interface OnClothesClickListener {
        fun onClothesClick(clothes: Clothes, position: Int)
    }

    class ClothesViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {
        val imageIV: ImageView = itemView.findViewById(R.id.imageIV)
        val nameTV: TextView = itemView.findViewById(R.id.nameTV)
//        val descriptionTV: TextView = itemView.findViewById(R.id.descriptionTV)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ClothesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_list_item, parent, false)
        return ClothesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClothesViewHolder, position: Int) {
        val clothes = clothes[position]
        holder.imageIV.setImageResource(clothes.image)
        holder.nameTV.text = clothes.name
//        holder.descriptionTV.text = clothes.description
        holder.itemView.setOnClickListener {
            if (onClothesClickListener!=null){
                onClothesClickListener!!.onClothesClick(clothes,position)
            }
        }
    }

    override fun getItemCount(): Int = clothes.size
    fun setOnClothesClickListner(onClothesClickListener: OnClothesClickListener) {
        this.onClothesClickListener = onClothesClickListener
    }
}