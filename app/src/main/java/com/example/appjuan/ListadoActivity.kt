package com.example.appjuan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.appjuan.databinding.ActivityListadoBinding
import com.example.appjuan.ui.CantidadViajes
import com.example.appjuan.ui.ExtrasFragment
import com.example.appjuan.ui.HorasTrabajos


class ListadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val radioGroup = binding.rgListado

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i){//definimos que fragmentos vamos a mostrar
                binding.rbCantViajes.id-> supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,CantidadViajes()).commit()
                binding.rbHorasTrabajo.id -> supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,HorasTrabajos()).commit()
                binding.rbExtras.id -> supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,ExtrasFragment()).commit()
            }
        }


    }

}