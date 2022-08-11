package com.example.appjuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.appjuan.databinding.ActivityMainBinding
import com.example.appjuan.db.Costo
import com.example.appjuan.db.CostoApp
import com.example.appjuan.db.HorasTrabajoRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    //val app = com.example.appjuan.ui.applicationContext as CostoApp
    private var onOpen:Double? = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCliente.setOnClickListener {//Viajamos a la segunda actividad (listado)
            startActivity(Intent(this,ListadoActivity::class.java))
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    onOpen = CostoApp.getDb().costoDao().obtenerPrecioNafta(1)

                    if (onOpen == 0.0) {//iniciamos todas las tablas
                        CostoApp.getDb().costoDao().iniciarTabla(Costo(0,0.1,0.1,0.1,0,0))
                        CostoApp.getDb().costoDao().iniciarHorasTrabajo(HorasTrabajoRoom(1,1,1))

                    }

                }
            }
        }


    }


}
