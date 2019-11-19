package com.example.apprep

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_avaliacao.*

class AvaliacaoActivity : AppCompatActivity() {

    lateinit var republica: Republica
    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avaliacao)

        republica = intent.getSerializableExtra(REPUBLICA) as Republica
        usuario = intent.getSerializableExtra(USUARIO) as Usuario
        val republicas: MutableList<Republica> = Paper.book().read(LISTA_REPUBLICAS) ?: mutableListOf()
        val index  = republicas.indexOf(republica)


        buttonSubmeterAvaliacao.setOnClickListener{
            val ratingValue = rating_bar.rating
            republica.avaliacaoSoma += ratingValue
            republica.countAvaliacao = republica.countAvaliacao + 1
            republica.avaliacaoMedia = republica.avaliacaoSoma/republica.countAvaliacao
            republicas[index] = republica
            Paper.book().write(LISTA_REPUBLICAS, republicas)
            val intent = Intent(this, ListaRepublicasActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }

        buttonVoltarAvaliacao.setOnClickListener{
            val intent = Intent(this, ListaReservasActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ListaReservasActivity::class.java)
        intent.putExtra(USUARIO, usuario)
        startActivity(intent)
        finish()
    }

}