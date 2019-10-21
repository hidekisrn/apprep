package com.example.apprep.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apprep.R
import com.example.apprep.Republica
import kotlinx.android.synthetic.main.republica_item_lista.view.*

class RepublicaAdapter (val context: Context, val republicas: List<Republica>)
    : RecyclerView.Adapter<RepublicaAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.republica_item_lista, parent, false)
            return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return republicas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, republicas[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(context: Context, republica: Republica){
            val endereco: String =  republica.rua + ", " + republica.num_residencia + " - " + republica.bairro + ", São Carlos - SP, " + republica.cep
            itemView.tvNome.text = republica.nome
            itemView.tvEndereço.text = endereco

        }
    }
}