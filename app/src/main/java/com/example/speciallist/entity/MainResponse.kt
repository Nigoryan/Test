package com.example.speciallist.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Response")
@Parcelize
data class MainResponse (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @SerializedName("response") val response : List<UserResponse>?
):Parcelable