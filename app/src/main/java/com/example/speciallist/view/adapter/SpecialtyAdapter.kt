package com.example.speciallist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.speciallist.R
import com.example.speciallist.entity.SpecialtyResponse
import com.example.speciallist.entity.UserResponse
import com.example.speciallist.view.ItemClickListener
import kotlinx.android.synthetic.main.recycler_spec_item.view.*

class SpecialtyAdapter(private val clickListener: ItemClickListener):RecyclerView.Adapter<SpecialtyAdapter.SpecialtyViewHolder>() {

    var list = listOf<Pair<List<SpecialtyResponse>?,List<UserResponse>>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_spec_item,parent,false)
        return SpecialtyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(item.second)
        }
    }

    override fun getItemCount(): Int = list.size

    fun setSpecialization(specialty: List<Pair<List<SpecialtyResponse>?,List<UserResponse>>>) {
        this.list = specialty
        notifyDataSetChanged()
    }

    class SpecialtyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvSpec = itemView.tvSpec
        fun bind(item: Pair<List<SpecialtyResponse>?,List<UserResponse>>){

            tvSpec.text = item.first?.get(0)?.name ?: "--"
        }
    }
}