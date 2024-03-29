package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adicao_de_endereco.*

// PASSO 1
class CadastraEnderecoActivity : AppCompatActivity() {

    var republica: Republica? = null
    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_endereco)
        usuario = intent.getSerializableExtra(USUARIO) as Usuario

        // caso o usuário volte para o passo 1 ele vai receber o usuário com dados preenchidos
        republica = intent.getSerializableExtra(REPUBLICA) as Republica?
        republica?.let {
            //TODO: preencher campos com as informações que constam no objeto, por exemplo:
            editTextCEP.setText(it.cep ?: "")
            editTextRua.setText(it.rua ?:"")
            editTextNumeroResidencia.setText(it.num_residencia ?: "")
            editTextBairro.setText(it.bairro ?: "")

            //.... outros campos
        }

        buttonProximoEndereco.setOnClickListener {
            if(editTextCEP.text.toString().isEmpty()){
                editTextCEP.requestFocus()
                editTextCEP.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(editTextRua.text.toString().isEmpty()){
                editTextRua.requestFocus()
                editTextRua.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(editTextNumeroResidencia.text.toString().isEmpty()){
                editTextNumeroResidencia.requestFocus()
                editTextNumeroResidencia.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(editTextBairro.text.toString().isEmpty()){
                editTextBairro.requestFocus()
                editTextBairro.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(republica == null) republica = Republica() // se estiver iniciando o cadatro cria uma nova republica
            // usamos ?.let para tratar objetos nullables
            republica?.let {
                it.rua = editTextRua.text.toString()
                it.cep = editTextCEP.text.toString()
                it.bairro = editTextBairro.text.toString()
                it.num_residencia = editTextNumeroResidencia.text.toString()
            }

            val intent = Intent(this, AdicaoCaracteristicaActivity::class.java)
            intent.putExtra(REPUBLICA, republica)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }

        // no passo 1 é só fechar que já volta pra lista.
        // TODO: colocar uma pergunta para confirmar se o usuário deseja cancelar o cadastro
        buttonVoltarEndereco.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }
    }

    // no passo 1 é só fechar que já volta pra lista.
    // TODO: colocar uma pergunta pra confirmar se o usuário deseja cancelar o cadastro
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, PerfilActivity::class.java)
        intent.putExtra(USUARIO, usuario)
        startActivity(intent)
        finish()
    }
}
