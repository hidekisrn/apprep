package com.example.apprep

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.republica_item_lista.view.*

class RepublicaAdapter(val context: Context, val republicas: List<Republica>) :
    RecyclerView.Adapter<RepublicaAdapter.ViewHolder>() {

    var clique: ((republica:Republica) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepublicaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.republica_item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return republicas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, republicas[position], clique)
    }

    fun configuraClique(clique: ((republica:Republica) -> Unit)){
        this.clique = clique
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(context: Context, republica: Republica, clique: ((republica:Republica) -> Unit)? ) {
            val endereco: String =
                republica.rua + ", " + republica.num_residencia + " - " + republica.bairro + ", São Carlos - SP, " + republica.cep
            itemView.tvNome.text = republica.nome
            itemView.tvEndereço.text = endereco
            if(republica.foto != null)
                itemView.imgFoto.setImageURI(Uri.parse(republica.foto))
                if(clique != null){
                itemView.setOnClickListener{
                    clique.invoke(republica)
                }
            }
        }
    }
}