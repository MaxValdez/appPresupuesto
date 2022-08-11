package com.example.appjuan.funciones

import com.example.appjuan.db.CostoApp

class Funciones {

    fun presupuesto():Double{
        var total=0.0
        var totalCombustible=0.0
        var totalHorasTrabajo = 0
        var precioNaftaPresupuesto = CostoApp.getDb().costoDao().obtenerPrecioNafta(1)
        var distanciaPresupuesto = CostoApp.getDb().costoDao().obtenerDistancia(1).toDouble()
        var cantidadViajesPresupuesto = CostoApp.getDb().costoDao().obtenerCantViajes(1)
        //Horas trabajo
         var horasViajePresupuesto = CostoApp.getDb().costoDao().obtenerHorasViaje(1)
        var manoObraPresupuesto = CostoApp.getDb().costoDao().obtenerManoObra(1)

        totalHorasTrabajo = horasViajePresupuesto + manoObraPresupuesto + (manoObraPresupuesto/2)
        totalCombustible=(precioNaftaPresupuesto*distanciaPresupuesto)
        total = ((totalCombustible+(totalCombustible/2))*cantidadViajesPresupuesto)+ totalHorasTrabajo
        return total

    }


}