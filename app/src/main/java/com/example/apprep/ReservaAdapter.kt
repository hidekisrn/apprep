package com.example.apprep

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import io.paperdb.Paper
import kotlinx.android.synthetic.main.reserva_item_lista.view.*

class ReservaAdapter(
    val context: Context,
    val reservas: List<Reserva>,
    val usuario: Usuario) :
    RecyclerView.Adapter<ReservaAdapter.ViewHolder>() {

    var clique: ((reserva:Reserva) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.reserva_item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reservas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, reservas[position], clique, usuario)
    }

    fun configuraClique(clique: ((reserva:Reserva) -> Unit)){
        this.clique = clique
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(
            context: Context,
            reserva: Reserva,
            clique: ((reserva: Reserva) -> Unit)?,
            usuario: Usuario
        ) {
            val republica: Republica
            val republicas: MutableList<Republica> = Paper.book().read(LISTA_REPUBLICAS) ?: mutableListOf()
            republica = republicas.first {
                reserva.republica == it.nome
            }
            val usuarios: MutableList<Usuario> = Paper.book().read(LISTA_USUARIOS) ?: mutableListOf()
            val usuarioRep: Usuario = usuarios[republica.usuario]
            itemView.tvNomeRep.text = reserva.nome_reserva
            itemView.tvCheckin.text = reserva.data_chegada
            if(reserva.foto_reserva != null) {
                itemView.imgFotoCapa.setImageURI(Uri.parse(reserva.foto_reserva))
            }
            itemView.buttonAvaliar.setOnClickListener{
                val intent = Intent(context, AvaliacaoActivity::class.java)
                intent.putExtra(REPUBLICA, republica)
                intent.putExtra(USUARIO, usuario)
                startActivity(context, intent, null)
            }
            itemView.buttonContatarDono.setOnClickListener{
                Toast.makeText(context, "Telefone para contato: " + usuarioRep.telefone, Toast.LENGTH_LONG).show()
            }
            if(clique != null){
                itemView.setOnClickListener{
                    clique.invoke(reserva)
                }
            }
        }
    }
}