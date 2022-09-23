package com.borabor.marsrealestate.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.borabor.marsrealestate.R
import com.borabor.marsrealestate.data.model.Property
import com.borabor.marsrealestate.databinding.ItemPropertyBinding

class PropertyAdapter(
    /**
     * Holds the [Property] data of clicked item.
     */
    private val onItemClicked: (property: Property) -> Unit
) : ListAdapter<Property, PropertyAdapter.ViewHolder>(DiffCallback) {
    inner class ViewHolder(val view: ItemPropertyBinding) : RecyclerView.ViewHolder(view.root) {
        init {
            view.root.setOnClickListener {
                onItemClicked(getItem(adapterPosition))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_property, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.property = getItem(position)
    }

    object DiffCallback : DiffUtil.ItemCallback<Property>() {
        override fun areItemsTheSame(oldItem: Property, newItem: Property) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Property, newItem: Property) = oldItem == newItem
    }
}