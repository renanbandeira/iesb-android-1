package com.example.myapplication.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Country")
data class Country(@PrimaryKey @NonNull @ColumnInfo(name = "name") @SerializedName("name") val name: String = "")