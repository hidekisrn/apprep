package com.example.apprep

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_detalhes_republica.*
import kotlinx.android.synthetic.main.activity_detalhes_republica2.*

class DetalhesRepublica2 : AppCompatActivity() {

    lateinit var reserva: Reserva
    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_republica2)


        reserva = intent.getSerializableExtra(RESERVA) as Reserva
//        val republica: Republica? = intent.getSerializableExtra(REPUBLICA) as Republica?
        usuario = intent.getSerializableExtra(USUARIO) as Usuario
        carregaDadosReserva(reserva)
//        if (republica != null) carregaDados(republica)

        buttonVoltarDetalhes2.setOnClickListener {
            val intent = Intent(this, ListaReservasActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }
    }

//    override fun onResume() {
//    super.onResume()
//
//    }

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
        dtNomeRep2.text = republica.nome
        dtEndereco2.text = endereco
        dtBanheiros2.text = banheiro
        dtPreco2.text = preco
        dtVagas2.text = vagas
        dtVagasCarro2.text = vagasCarro
        dtDetalhes2.text = detalhes
        dtrating_bar2.rating = republica.avaliacaoMedia
        if(republica.foto != null)
            imgFotoCapa.setImageURI(Uri.parse(republica.foto))
    }

    private fun carregaDadosReserva(reserva: Reserva) {
        val endereco: String =
            reserva.rua_reserva + ", " + reserva.num_residencia_reserva + " - " + reserva.bairro_reserva +  ", São Carlos - SP, " + reserva.cep_reserva
        val preco: String =
            "R$" + reserva.preco_reserva + " pernoite"
        val vagas: String? =
            "Vagas disponíveis: " + reserva.vagas_reserva
        val vagasCarro: String? =
            "Vagas para carro: " + reserva.vagasCarro_reserva
        val banheiro: String? =
            "Banheiros: " + reserva.banheiros_reserva
        val detalhes: String? =
            "Detalhes: \n" + reserva.descricao_reserva
        dtNomeRep2.text = reserva.nome_reserva
        dtEndereco2.text = endereco
        dtBanheiros2.text = banheiro
        dtPreco2.text = preco
        dtVagas2.text = vagas
        dtVagasCarro2.text = vagasCarro
        dtDetalhes2.text = detalhes
        if(reserva.foto_reserva != null)
            imgFotoCapa.setImageURI(Uri.parse(reserva.foto_reserva))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ListaReservasActivity::class.java)
        intent.putExtra(USUARIO, usuario)
        startActivity(intent)
        finish()
    }
}