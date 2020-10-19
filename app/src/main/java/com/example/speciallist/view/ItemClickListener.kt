package com.example.speciallist.view

import com.example.speciallist.entity.UserResponse

interface ItemClickListener {
    fun onItemClick(user: UserResponse)
}