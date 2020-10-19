package com.example.speciallist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.speciallist.dao.UserDAO
import com.example.speciallist.db.converter.Converter
import com.example.speciallist.db.converter.MainConverter
import com.example.speciallist.db.converter.SpecialtyConverter
import com.example.speciallist.db.converter.UserConverter
import com.example.speciallist.entity.MainResponse
import com.example.speciallist.entity.SpecialtyResponse
import com.example.speciallist.entity.UserResponse

@Database(version = 1, entities = [MainResponse::class, SpecialtyResponse::class, UserResponse::class])
@TypeConverters(Converter::class, MainConverter::class, SpecialtyConverter::class, UserConverter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract val getUserDAO : UserDAO
}