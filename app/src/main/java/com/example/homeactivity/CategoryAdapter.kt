package com.example.homeactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val categories: List<Category>,
    private val onItemClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvCategoryName)
        val tvDescription: TextView = view.findViewById(R.id.tvCategoryDescription)
        val tvTotal: TextView = view.findViewById(R.id.tvTotalItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.tvName.text = category.name
        holder.tvDescription.text = category.description
        holder.tvTotal.text = "Total Item: ${category.totalItems}"

        holder.itemView.setOnClickListener { onItemClick(category) }
    }

    override fun getItemCount(): Int = categories.size
}
