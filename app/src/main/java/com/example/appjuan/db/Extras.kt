package com.example.appjuan.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Extras(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var elemento:String
)
