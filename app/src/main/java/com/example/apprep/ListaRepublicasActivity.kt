package com.example.apprep

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_republicas)
        usuario = intent.getSerializableExtra(USUARIO) as Usuario

        repminhasReservas.setOnClickListener {
            val intent = Intent(this, ListaReservasActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }

        repmeuPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra(USUARIO, usuario)
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
            detalhesRepublica.putExtra(USUARIO, usuario)
            this.startActivity(detalhesRepublica)
            this.finish()
//            val usuario: Usuario
//            val usuarios: MutableList<Usuario> = Paper.book().read(LISTA_USUARIOS) ?: mutableListOf()
//            usuario = usuarios[it.usuario]
        }

        rvRepublicas.adapter = adapter
        rvRepublicas.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, login::class.java)
        startActivity(intent)
        finish()
    }
}