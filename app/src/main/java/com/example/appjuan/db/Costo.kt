package com.example.appjuan.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Costo(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var precioNafta:Double,
    var manoObra: Double,
    var horaViaje: Double,
    var distancia: Int,
    var cantidadViajes:Int
)
