package com.example.apprep

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detalhes_republica.*

class DetalhesRepublica : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_republica)

        val republica: Republica? = intent.getSerializableExtra(REPUBLICA) as Republica?
        if(republica != null)
            carregaDados(republica)

        buttonReservarRep.setOnClickListener{
            val intent = Intent(this, ReservaDeVagaActivity::class.java)
            intent.putExtra(REPUBLICA, republica)
            startActivity(intent)
            finish()
        }
    }

    private fun carregaDados(republica: Republica) {
        val endereco: String =
            republica.rua + ", " + republica.num_residencia + " - " + republica.bairro +  ", São Carlos - SP, " + republica.cep
        val preco: String =
            "R$" + republica.preco + " pernoite"
        val vagas: String? =
            "Vagas disponíveis: " + republica.vagas
        val vagasCarro: String? =
            "Vagas para carro: " + republica.vagasCarro
        val banheiro: String? =
            "Banheiros: " + republica.banheiros
        val detalhes: String? =
            "Detalhes: \n" + republica.descricao
        dtNomeRep.setText(republica.nome)
        dtEndereco.setText(endereco)
        dtBanheiros.setText(banheiro)
        dtPreco.setText(preco)
        dtVagas.setText(vagas)
        dtVagasCarro.setText(vagasCarro)
        dtDetalhes.setText(detalhes)
        if(republica.foto != null)
            imgFotoCapa.setImageURI(Uri.parse(republica.foto))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ListaRepublicasActivity::class.java)
        startActivity(intent)
        finish()
    }
}