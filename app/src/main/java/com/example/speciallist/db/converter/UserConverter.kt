package com.example.speciallist.db.converter

import androidx.room.TypeConverter
import com.example.speciallist.entity.UserResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserConverter {
    @TypeConverter
    fun stringToListUser(json: String): List<UserResponse>? {
        val type = object : TypeToken<List<UserResponse>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun userToListString(name: List<UserResponse>): List<String> {
        val type = object : TypeToken<List<UserResponse>>() {}.type
        return listOf(Gson().toJson(name, type))
    }
}