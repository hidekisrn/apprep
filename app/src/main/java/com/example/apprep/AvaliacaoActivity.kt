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

    lateinit var reserva: Reserva

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avaliacao)

//        reserva = intent.getSerializableExtra(RESERVA) as Reserva
//        val reservas: MutableList<Reserva> = Paper.book().read(LISTA_RESERVAS) ?: mutableListOf()
//        val index  = reservas.indexOf(reserva)


        buttonSubmeterAvaliacao.setOnClickListener{
            val ratingValue = rating_bar.rating
//            reserva.count += 1
//            reserva.avaliacao_reserva = reserva.avaliacao_reserva?.plus(ratingValue)?.div(reserva.count)
//            reservas.set(index, reserva)
//            Paper.book().write(LISTA_RESERVAS, reservas)
        }

        buttonVoltarAvaliacao.setOnClickListener{
            val intent = Intent(this, ListaReservasActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ListaReservasActivity::class.java)
        startActivity(intent)
        finish()
    }

}