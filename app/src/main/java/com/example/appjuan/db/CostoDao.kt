package com.example.appjuan.db

import androidx.room.*

@Dao
interface CostoDao {
    //CONSULTAS PARA OBTENER LOS VALORES
    @Query("SELECT manoObra from HorasTrabajoRoom where id = :id")
    fun obtenerManoObra(id:Int):Int

    @Query("SELECT horasViaje  from HorasTrabajoRoom where id = :id")
    fun obtenerHorasViaje(id:Int):Int

    @Query("SELECT precioNafta FROM Costo where id = :id")
      fun obtenerPrecioNafta(id:Int):Double

    @Query("SELECT distancia FROM Costo where id = :id")
    fun obtenerDistancia(id:Int):Int

    @Query("SELECT cantidadViajes FROM Costo where id = :id")
    fun obtenerCantViajes(id:Int):Int

    @Query("SELECT elemento FROM Extras")
    fun obtenerExtras():List<String>

    //CONSULTAS PARA ACTUALIZAR LOS VALORES
    @Query("UPDATE HorasTrabajoRoom set manoObra = :manoObra where id = :id")
    fun actualizarManoObra(manoObra:Int,id: Int)

    @Query("UPDATE Extras set elemento=:elemento where id= :id")
    fun actualizarElemento(elemento:String,id:Int)

    @Query("UPDATE Costo set distancia = :distancia where id = :id ")
    fun actualizarDistancia(distancia: Int, id:Int)

      @Query("UPDATE Costo set precioNafta = :precioNafta where id = :id ")
      fun actualizarPrecioNafta(precioNafta: Double, id:Int)

    @Query("UPDATE Costo set cantidadViajes = :cantidadViajes where id = :id ")
    fun actualizarCantViajes(cantidadViajes: Int, id:Int)

    @Query("UPDATE HorasTrabajoRoom set horasViaje = :horasViaje where id = :id")
    fun actualizarHorasViaje(horasViaje:Int,id:Int)
    //INICIAMOS LAS TABLAS
    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun iniciarTabla(costos:Costo)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun iniciarHorasTrabajo(horasTrabajoRoom: HorasTrabajoRoom)
    //INSERTS
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertarExtras(extras:Extras)

}