package com.example.speciallist.di

import android.app.Application
import androidx.room.Room
import com.example.speciallist.dao.UserDAO
import com.example.speciallist.db.DatabaseBuilder
import com.example.speciallist.db.UserDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module{
    fun provideDatabase(application: Application): UserDatabase {
        return Room.databaseBuilder(application, UserDatabase::class.java, "user_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideUserDAO(database: UserDatabase): UserDAO {
        return  database.getUserDAO
    }

    single { provideDatabase(androidApplication()) }
    single { provideUserDAO(get()) }
}