package com.example.speciallist.db.converter

import androidx.room.TypeConverter
import com.example.speciallist.entity.SpecialtyResponse
import com.example.speciallist.entity.UserResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SpecialtyConverter {
    @TypeConverter
    fun stringToSpecialty(json: String): List<SpecialtyResponse>? {
        val type = object : TypeToken<List<SpecialtyResponse>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun specialtyToListString(specialty: List<SpecialtyResponse>): String {
        val type = object : TypeToken<List<SpecialtyResponse>>() {}.type
        return Gson().toJson(specialty, type)
    }
}