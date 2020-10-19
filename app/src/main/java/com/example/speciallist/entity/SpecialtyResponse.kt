package com.example.speciallist.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Specialty")
@Parcelize
data class SpecialtyResponse (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("specialty_id") val specialty_id : Int?,
    @SerializedName("name") val name : String?
):Parcelable