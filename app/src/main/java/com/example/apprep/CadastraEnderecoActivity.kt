package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adicao_de_endereco.*

class CadastraEnderecoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_endereco)

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

            val novaRepublica = Republica(editTextRua.text.toString(), editTextCEP.text.toString(),
                editTextBairro.text. toString(), editTextNumeroResidencia.text.toString())

            val intent = Intent(this, AdicaoCaracteristicaActivity::class.java)
            intent.putExtra("novaRepublica", novaRepublica)
            startActivity(intent)
            finish()
        }

        buttonVoltarEndereco.setOnClickListener {
            val intent = Intent(this, perfil::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, perfil::class.java)
        startActivity(intent)
        finish()
    }
}
