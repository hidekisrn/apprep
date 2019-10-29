package com.example.apprep

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detalhes_republica.*

class DetalhesRepublica : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_republica)

        val republica: Republica? = intent.getSerializableExtra("novaRepublica") as Republica?
        if(republica != null)
            carregaDados(republica)
    }

    private fun carregaDados(republica: Republica) {
        val endereco: String =
            republica.rua + ", " + republica.num_residencia + " - " + republica.bairro +  ", São Carlos - SP, " + republica.cep
        val preco: String =
            "R$" + republica.preco + " pernoite"
        val vagas: String? =
            republica.vagas + " vagas disponíveis"
        val vagasCarro: String? =
            republica.vagasCarro + " vagas para carro"
        val banheiro: String? =
            republica.banheiros + " banheiros"
        dtNomeRep.setText(republica.nome)
        dtEndereco.setText(endereco)
        dtBanheiros.setText(banheiro)
        dtPreco.setText(preco)
        dtVagas.setText(vagas)
        dtVagasCarro.setText(vagasCarro)
        if(republica.foto != null)
            imgFotoCapa.setImageURI(Uri.parse(republica.foto))

    }


}