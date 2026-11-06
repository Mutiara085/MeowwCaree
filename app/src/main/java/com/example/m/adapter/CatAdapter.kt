package com.example.m.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.m.databinding.ItemCatBinding
import com.example.m.model.Cat

class CatAdapter(
    private val onItemClick: (Cat) -> Unit
) : ListAdapter<Cat, CatAdapter.CatViewHolder>(CatDiffCallback) {

    inner class CatViewHolder(val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = getItem(position)
        holder.binding.apply {
            ivCat.setImageResource(cat.imageResId)
            tvCatName.text = cat.name
            tvCatSub.text = "${cat.gender} • ${cat.age}"

            val clickListener = android.view.View.OnClickListener {
                onItemClick(cat)
            }

            cardCat.setOnClickListener(clickListener)
            clItem.setOnClickListener(clickListener)
            ivCat.setOnClickListener(clickListener)
            tvCatName.setOnClickListener(clickListener)
            tvCatSub.setOnClickListener(clickListener)
            tvDetailLink.setOnClickListener(clickListener)
        }
    }

    object CatDiffCallback : DiffUtil.ItemCallback<Cat>() {
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }
    }
}