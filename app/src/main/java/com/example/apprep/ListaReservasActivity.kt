package com.example.apprep

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_lista_de_reservas.*


class ListaReservasActivity: AppCompatActivity() {

    lateinit var republica: Republica

    var listaReserva: List<Reserva>? = null
        set(value) {
            field = value
            setAdapter(value)
        }

//    lateinit var displayList: MutableList<Reserva>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_reservas)
        republica = intent.getSerializableExtra(REPUBLICA) as Republica
//        if (listaReserva != null) displayList.addAll(listaReserva!!.asIterable())
    }

    override fun onResume() {
        super.onResume()
        listaReserva = Paper.book().read(LISTA_RESERVAS) // Paper é uma lib para armazenar dados no dispositivo
    }

    private fun setAdapter(list: List<Reserva>?) {
        val adapter = ReservaAdapter(this, listaReserva ?: listOf(), republica)
        adapter.configuraClique {reserva ->
            val detalhesRepublica = Intent(this, DetalhesRepublica::class.java)
            detalhesRepublica.putExtra(RESERVA, reserva)
            this.startActivity(detalhesRepublica)
        }

        rvReservas.adapter = adapter
        rvReservas.layoutManager = LinearLayoutManager(this)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.search, menu)
//        val searchItem = menu.findItem(R.id.search_bar)
//        if(searchItem != null) {
//            val searchView = searchItem.actionView as SearchView
//            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//                override fun onQueryTextChange(newText: String?): Boolean {
//
//                    if(newText!!.isNotEmpty()){
//
//                        displayList.clear()
//                        rvReservas.adapter?.notifyDataSetChanged()
//
//                    } else {
//                        displayList.clear()
//                        if (listaReserva != null) displayList.addAll(listaReserva!!.asIterable())
//                        rvReservas.adapter?.notifyDataSetChanged()
//                    }
//
//                    return true
//                }
//
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    return true
//                }
//
//            })
//        }
//
//
//        return super.onCreateOptionsMenu(menu)
//    }
}