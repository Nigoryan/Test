package com.example.speciallist.network

import com.example.speciallist.entity.MainResponse
import com.example.speciallist.entity.UserResponse
import retrofit2.http.GET

interface UserService {
    @GET("testTask.json")
    suspend fun getUserInformation(): MainResponse
}