package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adicao_de_caracteristica.*


class AdicaoCaracteristicaActivity : AppCompatActivity() {

    var counterAcomodacao = 0
    var counterBanheiro = 0
    var counterCarro = 0

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_caracteristica)

        buttonDecrementarAcomodacao.setOnClickListener {
            if (counterAcomodacao > 0)
                counterAcomodacao--
            acomodacaoCounter.setText(counterAcomodacao.toString())
        }

        buttonIncrementarAcomodacao.setOnClickListener {
            counterAcomodacao++
            acomodacaoCounter.setText(counterAcomodacao.toString())
        }

        buttonDecrementarBanheiro.setOnClickListener {
            if (counterBanheiro > 0)
                counterBanheiro--
            banheiroCounter.setText(counterBanheiro.toString())
        }

        buttonIncrementarBanheiro.setOnClickListener {
            counterBanheiro++
            banheiroCounter.setText(counterBanheiro.toString())
        }

        buttonDecrementarCarro.setOnClickListener {
            if (counterCarro > 0)
                counterCarro--
            carroCounter.setText(counterBanheiro.toString())
        }

        buttonIncrementarCarro.setOnClickListener {
            counterCarro++
            carroCounter.setText(counterBanheiro.toString())
        }

        buttonProximoCaracteristica.setOnClickListener {
            if (editTextNomedaRepublica.text.toString().isEmpty()) {
                editTextNomedaRepublica.requestFocus()
                editTextNomedaRepublica.setError("Campo obrigatório")
                return@setOnClickListener
            }

            if (editTextPreco.text.toString().isEmpty()) {
                editTextPreco.requestFocus()
                editTextPreco.setError("Campo obrigatório")
                return@setOnClickListener
            }

            if (editTextDescricaoAcomodacao.text.toString().isEmpty()) {
                editTextDescricaoAcomodacao.requestFocus()
                editTextDescricaoAcomodacao.setError("Campo obrigatório")
                return@setOnClickListener
            }


            val novaRepublica: Republica? =
                intent.getSerializableExtra("novaRepublica") as Republica
            if (novaRepublica != null) {
                novaRepublica.nome = editTextNomedaRepublica.text.toString()
                novaRepublica.banheiros = counterBanheiro.toString()
                novaRepublica.preco = editTextPreco.text.toString()
                novaRepublica.vagas = counterAcomodacao.toString()
                novaRepublica.vagasCarro = counterCarro.toString()
                val intent = Intent(this, AdicaoFotoActivity::class.java)
                intent.putExtra("novaRepublica", novaRepublica)
                startActivity(intent)
            }

            buttonVoltarCaracteristica.setOnClickListener {
                val intent = Intent(this, CadastraEnderecoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
