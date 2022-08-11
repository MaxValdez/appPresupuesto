package com.example.appjuan.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HorasTrabajoRoom(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var horasViaje:Int,
    var manoObra:Int

)
