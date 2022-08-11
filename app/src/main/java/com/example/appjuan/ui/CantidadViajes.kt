package com.example.appjuan.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.appjuan.databinding.FragmentCantidadViajesBinding
import com.example.appjuan.db.CostoApp
import com.example.appjuan.db.viewmodel.MainViewModel
import com.example.appjuan.funciones.Funciones
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CantidadViajes : Fragment() {
    private lateinit var viewModel:MainViewModel
    private var _binding: FragmentCantidadViajesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCantidadViajesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var precioNafta=0.0
        val funciones:Funciones= Funciones()
        viewModel = ViewModelProvider(this).get()
        var presupuestoObserver = Observer<Double>{
            binding.tvPantalla.text = it.toString()
        }
        viewModel.traerPresupuestoLiveData().observe(viewLifecycleOwner,presupuestoObserver)


        lifecycleScope.launch (Dispatchers.IO) {//mostramos el presupuesto en pantalla al iniciar

            binding.tvPantalla.text = funciones.presupuesto().toString()
        }

        binding.btnDistancia.setOnClickListener {//boton para actualizar la distancia del viaje
            var distancia = binding.tvDistancia.text.toString()


            lifecycleScope.launch (Dispatchers.IO) {
                CostoApp.getDb().costoDao().actualizarDistancia(distancia.toInt(), 1)
                viewModel.traerPresupuesto()
            }

        }
        binding.btnPrecioCombustible.setOnClickListener {//Boton para actualizar el precio de la nafta

            var precioCombustuble = binding.tvPrecioCombustible.text.toString()
            precioNafta = precioCombustuble.toDouble()

            lifecycleScope.launch (Dispatchers.IO) {
                CostoApp.getDb().costoDao().actualizarPrecioNafta(precioNafta,1)
                viewModel.traerPresupuesto()
                //binding.tvPantalla.text = CostoApp.getDb().costoDao().obtenerPrecioNafta(1).toString()
            }
        }

        binding.btnCantViajes.setOnClickListener {//boton para actualizar la cantidad de viajes
            var cantViajes = binding.tvCantidadViajes.text.toString().toInt()
            lifecycleScope.launch (Dispatchers.IO) {
               // var cantViajes = binding.tvCantidadViajes.text.toString().toInt()
                CostoApp.getDb().costoDao().actualizarCantViajes(cantViajes, 1)
                viewModel.traerPresupuesto()
            }
        }
    }

}



