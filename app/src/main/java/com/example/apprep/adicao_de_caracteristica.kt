package com.example.apprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View;
import android.widget.Button;
import kotlinx.android.synthetic.main.activity_adicao_de_caracteristica.*


class adicao_de_caracteristica : AppCompatActivity() {

    var counterAcomodacao = 0
    var counterBanheiro = 0
    var counterCarro = 0

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_caracteristica)

        buttonDecrementarAcomodacao.setOnClickListener {
            counterAcomodacao--
            acomodacaoCounter.setText(counterAcomodacao.toString())
        }

        buttonIncrementarAcomodacao.setOnClickListener {
            counterAcomodacao++
            acomodacaoCounter.setText(counterAcomodacao.toString())
        }

        buttonDecrementarBanheiro.setOnClickListener {
            counterBanheiro--
            banheiroCounter.setText(counterBanheiro.toString())
        }

        buttonIncrementarBanheiro.setOnClickListener {
            counterBanheiro++
            banheiroCounter.setText(counterBanheiro.toString())
        }

        buttonDecrementarCarro.setOnClickListener {
            counterCarro --
            carroCounter.setText(counterBanheiro.toString())
        }

        buttonIncrementarCarro.setOnClickListener {
            counterCarro++
            carroCounter.setText(counterBanheiro.toString())
        }

        buttonProximoCaracteristica.setOnClickListener {
            if(editTextNomedaRepublica.text.toString().isEmpty()){
                editTextNomedaRepublica.requestFocus()
                editTextNomedaRepublica.setError("Campo obrigatório")
                return@setOnClickListener
            }

            if(editTextPreco.text.toString().isEmpty()){
                editTextPreco.requestFocus()
                editTextPreco.setError("Campo obrigatório")
                return@setOnClickListener
            }

            if(editTextDescricaoAcomodacao.text.toString().isEmpty()){
                editTextDescricaoAcomodacao.requestFocus()
                editTextDescricaoAcomodacao.setError("Campo obrigatório")
                return@setOnClickListener
            }
        }
    }
}
