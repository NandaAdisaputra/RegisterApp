package com.nandaadisaputra.registerapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,
    @ColumnInfo(name = "name")
    var name: String? = "",
    @ColumnInfo(name = "number")
    var number: String? = "",
    @ColumnInfo(name = "gender")
    var gender: String? = "",
    @ColumnInfo(name = "age")
    var age: String? = "",
    @ColumnInfo(name = "date")
    var date: String? = "",
) : Parcelable