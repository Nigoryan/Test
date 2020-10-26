package com.example.speciallist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.speciallist.R
import com.example.speciallist.entity.UserResponse
import com.example.speciallist.util.dateToAge
import com.example.speciallist.view.UserItemClickListener
import kotlinx.android.synthetic.main.recycler_user_inform_item.view.*

class UserInformAdapter(private val userItemClickListener: UserItemClickListener): RecyclerView.Adapter<UserInformAdapter.UserInformViewHolder>()  {
    var userInformList = listOf<UserResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInformViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_user_inform_item,parent,false)
        return UserInformViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserInformViewHolder, position: Int) {
        val item = userInformList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            userItemClickListener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int = userInformList.size

    fun setUserInform(userInform: List<UserResponse>?) {
        if (userInform != null) {
            this.userInformList = userInform
        }
        notifyDataSetChanged()
    }

    class UserInformViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val ivIcon = itemView.ivIcon
        private val tvFName = itemView.tvFName
        private val tvLName = itemView.tvLName
        private val tvAge = itemView.tvAge
        fun bind(item:UserResponse){
            if(item.avatar!=null && item.avatar.isNotEmpty())
                Glide.with(itemView.context).load(item.avatar).into(ivIcon)
            tvFName.text = item.firstName
            tvLName.text = item.lastName
            val age = dateToAge(item.birthday)
            if(age!=null){
                tvAge.text = age.toString()
            }else{
                tvAge.text = "----"
            }
        }
    }
}