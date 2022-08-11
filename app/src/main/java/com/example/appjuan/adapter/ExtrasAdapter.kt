package com.example.appjuan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appjuan.R

/*class ExtrasAdapter(private var extras:List<String>):RecyclerView.Adapter<ExtrasViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtrasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ExtrasViewHolder(layoutInflater.inflate(R.layout.extras_rv,parent,false))
    }

    override fun onBindViewHolder(holder: ExtrasViewHolder, position: Int) {
        val item = extras[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = extras.size

}*/
class ExtrasAdapter(private val context:Context?,private var extras:List<String>,private val itemClickListener:ExtraClicks):RecyclerView.Adapter<BaseViewHolder<*>>(){

    interface ExtraClicks{
        fun itemClick(item: String)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val layoutInflater = LayoutInflater.from(context)
        return ExtrasViewHolder(layoutInflater.inflate(R.layout.extras_rv,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
       when(holder){
           is ExtrasViewHolder -> holder.render(extras[position],position)
       }
    }

    override fun getItemCount(): Int = extras.size

     inner class ExtrasViewHolder(itemView:View):BaseViewHolder<String>(itemView){
        override fun render(item: String, position: Int) {
            itemView.setOnClickListener { itemClickListener.itemClick(item)}
            itemView.findViewById<TextView>(R.id.tvExtrasTexto).text = item
        }

    }
}