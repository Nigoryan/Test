package com.example.speciallist.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "UserInform")
@Parcelize
data class UserResponse(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("f_name") val firstName: String?,
    @SerializedName("l_name") val lastName: String?,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("avatar_url") val avatar: String?,
    @SerializedName("specialty") val specialty : List<SpecialtyResponse>?
):Parcelable