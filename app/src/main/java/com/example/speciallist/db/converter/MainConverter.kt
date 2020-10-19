package com.example.speciallist.db.converter

import androidx.room.TypeConverter
import com.example.speciallist.entity.MainResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainConverter {
    @TypeConverter
    fun stringToMain(value: String): MainResponse? {
        val type = object : TypeToken<MainResponse>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun mainToString(main: MainResponse): String {
        val type = object : TypeToken<MainResponse>() {}.type
        return Gson().toJson(main, type)
    }
}