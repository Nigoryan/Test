package com.example.speciallist.view

import com.example.speciallist.entity.UserResponse

interface UserItemClickListener {
    fun onItemClick(userDetailInform: UserResponse)
}