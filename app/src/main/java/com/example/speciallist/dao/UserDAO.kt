package com.example.speciallist.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.speciallist.entity.UserResponse

@Dao
interface UserDAO {

    @Query("SELECT * FROM UserInform")
    fun getAllInform():List<UserResponse>

    @Query("SELECT * FROM UserInform GROUP BY Specialty")
    fun getAllSpecialty():List<UserResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addInformation(iform: List<UserResponse>)
}