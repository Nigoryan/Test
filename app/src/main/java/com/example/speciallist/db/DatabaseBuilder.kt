package com.example.speciallist.db

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var database: UserDatabase? = null

    fun getDatabase(context: Context):UserDatabase? {
        if(database == null){
            database = Room.databaseBuilder(
                context,
                UserDatabase::class.java,
                "user_db"
            ).build()
        }
        return database
    }
}