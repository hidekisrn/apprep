package com.example.apprep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_lista_de_reservas.*


class ListaReservasActivity: AppCompatActivity() {

    lateinit var usuario: Usuario

    var listaReserva: List<Reserva>? = null
        set(value) {
            field = value
            setAdapter(value)
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_reservas)

        reslistaDeRepublicas.setOnClickListener {
            val intent = Intent(this, ListaRepublicasActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }

        resmeuPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }

        usuario = intent.getSerializableExtra(USUARIO) as Usuario
    }

    override fun onResume() {
        super.onResume()
        listaReserva = Paper.book().read(usuario.cpf) // Paper é uma lib para armazenar dados no dispositivo
    }

    private fun setAdapter(list: List<Reserva>?) {
        val adapter2 = ReservaAdapter(this, listaReserva ?: listOf(), usuario)
        adapter2.configuraClique {reserva ->
            val detalhesRepublica2 = Intent(this, DetalhesRepublica2::class.java)
            detalhesRepublica2.putExtra(RESERVA, reserva)
            detalhesRepublica2.putExtra(USUARIO, usuario)
            this.startActivity(detalhesRepublica2)
        }

        rvReservas.adapter = adapter2
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
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, login::class.java)
        startActivity(intent)
        finish()
    }
}