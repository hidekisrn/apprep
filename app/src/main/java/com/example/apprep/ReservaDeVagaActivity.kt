package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reserva_vaga.*

class ReservaDeVagaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva_vaga)

        buttonReservar.setOnClickListener {
            if (editTextDataChegada.text.toString().isEmpty()) {
                editTextDataChegada.requestFocus()
                editTextDataChegada.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if (editTextHorarioChegada.text.toString().isEmpty()) {
                editTextHorarioChegada.requestFocus()
                editTextHorarioChegada.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if (editTextDataSaida.text.toString().isEmpty()) {
                editTextDataSaida.requestFocus()
                editTextDataSaida.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if (editTextPrecoTotal.text.toString().isEmpty()) {
                editTextPrecoTotal.requestFocus()
                editTextPrecoTotal.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            val novaReserva = Reserva(editTextDataChegada.text.toString(), editTextHorarioChegada.text.toString(),
                editTextDataSaida.text.toString(), editTextPrecoTotal.text.toString())

            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra("novaReserva", novaReserva)
            startActivity(intent)
            finish()
        }

        buttonVoltarReserva.setOnClickListener {
            val intent = Intent(this, DetalhesRepublica::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, DetalhesRepublica::class.java)
        startActivity(intent)
        finish()
    }
}