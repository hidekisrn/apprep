package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adicao_de_caracteristica.*

// PASSO 2
class AdicaoCaracteristicaActivity : AppCompatActivity() {

    var counterAcomodacao = 0
    var counterBanheiro = 0
    var counterCarro = 0

    lateinit var republica: Republica

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_caracteristica)
        val usuario = intent.getSerializableExtra(USUARIO) as Usuario

        republica = intent.getSerializableExtra(REPUBLICA) as Republica
        //TODO: preencher campos com as informações que constam no objeto, por exemplo:
        acomodacaoCounter.setText(republica.vagas ?: "0")
        banheiroCounter.setText(republica.banheiros ?: "0")
        carroCounter.setText(republica.vagasCarro ?: "0")
        editTextNomedaRepublica.setText(republica.nome ?: "")
        editTextPreco.setText(republica.preco ?: "")
        editTextDescricaoAcomodacao.setText(republica.descricao ?: "")
        //.... outros campos

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

            pegaNovosValores()
            val intent = Intent(this, AdicaoFotoActivity::class.java)
            intent.putExtra(REPUBLICA, republica)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }

        buttonVoltarCaracteristica.setOnClickListener {
            pegaNovosValores()
            val intent = Intent(this, CadastraEnderecoActivity::class.java)
            intent.putExtra(REPUBLICA, republica)

            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        pegaNovosValores()
        val intent = Intent(this, CadastraEnderecoActivity::class.java)
        intent.putExtra(REPUBLICA, republica)
        startActivity(intent)
        finish()
    }

    private fun pegaNovosValores() {
        republica.nome = editTextNomedaRepublica.text.toString()
        republica.banheiros = counterBanheiro.toString()
        republica.preco = editTextPreco.text.toString()
        republica.vagas = counterAcomodacao.toString()
        republica.vagasCarro = counterCarro.toString()
        republica.descricao = editTextDescricaoAcomodacao.text.toString()
    }
}
