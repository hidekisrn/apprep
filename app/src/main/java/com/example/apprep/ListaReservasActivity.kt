package com.example.apprep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprep.R
import com.example.apprep.Republica
import com.example.apprep.RepublicaAdapter
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_lista_de_reservas.*


class ListaReservasActivity: AppCompatActivity() {

//    lateinit var republica: Republica

    var listaReserva: List<Reserva>? = null
        set(value) {
            field = value
            setAdapter(value)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_reservas)
//        republica = intent.getSerializableExtra(REPUBLICA) as Republica
    }

    override fun onResume() {
        super.onResume()
        listaReserva = Paper.book().read(LISTA_RESERVAS) // Paper é uma lib para armazenar dados no dispositivo
    }

    private fun setAdapter(list: List<Reserva>?) {
        val adapter = ReservaAdapter(this, listaReserva ?: listOf())
//        adapter.configuraClique {it
//            val detalhesRepublica = Intent(this, DetalhesRepublica::class.java)
//            detalhesRepublica.putExtra(RESERVA, it)
//            this.startActivity(detalhesRepublica)
//        }

        rvReservas.adapter = adapter
        rvReservas.layoutManager = LinearLayoutManager(this)
    }
}