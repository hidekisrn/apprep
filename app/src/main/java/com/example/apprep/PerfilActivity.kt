package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lista_de_republicas.*
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        plistaDeRepublicas.setOnClickListener {
            val intent = Intent(this, ListaRepublicasActivity::class.java)
            startActivity(intent)
        }

        pminhasReservas.setOnClickListener {
            val intent = Intent(this, ListaReservasActivity::class.java)
            startActivity(intent)
        }

        adicionarRepublica.setOnClickListener {
            val intent = Intent(this, CadastraEnderecoActivity::class.java)
            startActivity(intent)
        }
    }
}
