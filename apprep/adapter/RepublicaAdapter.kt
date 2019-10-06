package com.example.apprep.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apprep.R
import kotlinx.android.synthetic.main.republica_item_lista.view.*

class RepublicaAdapter (val republicas: List<String>)
    : RecyclerView.Adapter<RepublicaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.republica_item_lista, parent, false)
            return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return republicas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(republicas[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(republicaNome: String){
            itemView.tvNome.text = republicaNome
        }
    }
}