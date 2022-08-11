package com.example.appjuan.db.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appjuan.funciones.Funciones

class MainViewModel:ViewModel() {

//    val liveData:MutableLiveData<Double> = MutableLiveData()
private val mutableLiveData = MutableLiveData<Double>()
        var funciones:Funciones = Funciones()
        fun establecerPresupuesto(presupuesto:Double){
               // mutableLiveData.value = presupuesto
                mutableLiveData.postValue(presupuesto)
        }
        fun traerPresupuesto(){
                establecerPresupuesto(funciones.presupuesto())
        }
        fun traerPresupuestoLiveData():LiveData<Double>{
                return mutableLiveData
        }
}