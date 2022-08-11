package com.example.appjuan.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appjuan.R
import com.example.appjuan.adapter.ExtrasAdapter
import com.example.appjuan.databinding.FragmentExtrasBinding
import com.example.appjuan.db.CostoApp
import com.example.appjuan.db.Extras
import com.example.appjuan.db.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExtrasFragment : Fragment(),ExtrasAdapter.ExtraClicks{

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentExtrasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExtrasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contexto = context
        binding.rvExtras.layoutManager = LinearLayoutManager(activity)
        binding.rvExtras.addItemDecoration(DividerItemDecoration(contexto,DividerItemDecoration.VERTICAL))
        lifecycleScope.launch(Dispatchers.IO) {
            binding.rvExtras.adapter = ExtrasAdapter(contexto,CostoApp.getDb().costoDao().obtenerExtras(),this@ExtrasFragment)
        }
        binding.btnExtras.setOnClickListener {//Boton para cargar un item "Extra"
            var extras = binding.etExtras.text
            lifecycleScope.launch(Dispatchers.IO) {
                CostoApp.getDb().costoDao().insertarExtras(Extras(0, extras.toString()))
            }


        }
}

    override fun itemClick(item: String) {
        val fragment = DetalleExtrasFragment()
        Toast.makeText(context,"probando",Toast.LENGTH_LONG).show()
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragmentContainerView,fragment).commit()
        }

    }
}