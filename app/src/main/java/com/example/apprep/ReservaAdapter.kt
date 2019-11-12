package com.example.apprep

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.reserva_item_lista.view.*

class ReservaAdapter(val context: Context, val reservas: List<Reserva>) :
    RecyclerView.Adapter<ReservaAdapter.ViewHolder>() {

//    var clique: ((reserva:Reserva) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.reserva_item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reservas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, reservas[position])
    }

//    fun configuraClique(clique: ((reserva:Reserva) -> Unit)){
//        this.clique = clique
//    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(context: Context, reserva: Reserva) {//, clique: ((reserva:Reserva) -> Unit)? ) {
            itemView.tvNomeRep.text = reserva.nome_rep
            itemView.tvCheckin.text = reserva.data_chegada
            if(reserva.foto_capa != null) {
                itemView.imgFotoCapa.setImageURI(Uri.parse(reserva.foto_capa))
            }
//            if(clique != null){
//                itemView.setOnClickListener{
//                    clique.invoke(reserva)
//                }
//            }
        }
    }
}