package com.example.appjuan.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.appjuan.R
import com.example.appjuan.databinding.FragmentCantidadViajesBinding
import com.example.appjuan.databinding.FragmentHorasTrabajosBinding
import com.example.appjuan.db.CostoApp
import com.example.appjuan.funciones.Funciones
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HorasTrabajos : Fragment() {
    private var _binding: FragmentHorasTrabajosBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHorasTrabajosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var presupuesto: Funciones = Funciones()

        lifecycleScope.launch(Dispatchers.IO){

            binding.tvPantallaHorasTrabajo.text = presupuesto.presupuesto().toString()
        }
        binding.btnHorasTrabajo.setOnClickListener { //actualizamos la cantidad de horas trabajadas
            lifecycleScope.launch(Dispatchers.IO){
                var horasViajesTv = binding.etHorasTrabajo.text
                CostoApp.getDb().costoDao().actualizarHorasViaje(horasViajesTv.toString().toInt(),1)

            }
        }
        binding.btnManoObra.setOnClickListener { //actualizamos la mano de obra
            lifecycleScope.launch(Dispatchers.IO){
                var manoObraTv = binding.etManoObra.text
                CostoApp.getDb().costoDao().actualizarHorasViaje(manoObraTv.toString().toInt(),1)

            }
        }
    }

}