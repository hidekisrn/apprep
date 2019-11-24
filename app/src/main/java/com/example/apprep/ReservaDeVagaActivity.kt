package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_reserva_vaga.*
import java.util.*

class ReservaDeVagaActivity : AppCompatActivity() {

    lateinit var republica: Republica
    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserva_vaga)

        republica = intent.getSerializableExtra(REPUBLICA) as Republica

        usuario = intent.getSerializableExtra(USUARIO) as Usuario


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

            val reserva = Reserva(editTextDataChegada.text.toString(), editTextHorarioChegada.text.toString(),
                editTextDataSaida.text.toString(), editTextPrecoTotal.text.toString(), republica.rua, republica.cep, republica.bairro,
                republica.num_residencia, republica.nome, republica.foto, republica.vagas, republica.vagasCarro, republica.banheiros,
                republica.preco, republica.descricao)

            reserva.republica = republica.nome

            //criar uma lista de reservas pra cada usuario
            val reservas: MutableList<Reserva> = Paper.book().read(usuario.cpf) ?: mutableListOf()
            reservas.add(reserva)
            Paper.book().write(usuario.cpf, reservas)

            val intent = Intent(this, ListaReservasActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            intent.putExtra(REPUBLICA, republica)
            startActivity(intent)
            finish()
        }

        buttonVoltarReserva.setOnClickListener {
            val intent = Intent(this, DetalhesRepublica::class.java)
            intent.putExtra(REPUBLICA, republica)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, DetalhesRepublica::class.java)
        intent.putExtra(REPUBLICA, republica)
        intent.putExtra(USUARIO, usuario)
        startActivity(intent)
        finish()
    }
}