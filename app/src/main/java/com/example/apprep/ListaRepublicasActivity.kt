package com.example.apprep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_lista_de_republicas.*


class ListaRepublicasActivity : AppCompatActivity() {

    var listaRepublica: List<Republica>? = null
        set(value) {
            field = value
            setAdapter(value)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_republicas)


        repminhasReservas.setOnClickListener {
            val intent = Intent(this, ListaReservasActivity::class.java)
            startActivity(intent)
            finish()
        }

        repmeuPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        listaRepublica = Paper.book().read(LISTA_REPUBLICAS) // Paper é uma lib para armazenar dados no dispositivo
    }

    private fun setAdapter(list: List<Republica>?) {
        val adapter = RepublicaAdapter(this, listaRepublica ?: listOf())
        adapter.configuraClique {
            val detalhesRepublica = Intent(this, DetalhesRepublica::class.java)
            detalhesRepublica.putExtra(REPUBLICA, it)
            this.startActivity(detalhesRepublica)
        }

        rvRepublicas.adapter = adapter
        rvRepublicas.layoutManager = LinearLayoutManager(this)
    }
}