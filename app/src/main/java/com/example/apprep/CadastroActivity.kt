package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        buttonFinalizarCadastro.setOnClickListener {
            if(editTextNome.text.toString().isEmpty()){
                editTextNome.requestFocus()
                editTextNome.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(editTextSobrenome.text.toString().isEmpty()){
                editTextSobrenome.requestFocus()
                editTextSobrenome.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(editTextTelefone.text.toString().isEmpty()){
                editTextTelefone.requestFocus()
                editTextTelefone.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(editTextCPF.text.toString().isEmpty()){
                editTextCPF.requestFocus()
                editTextCPF.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(editTextEmail.text.toString().isEmpty()){
                editTextEmail.requestFocus()
                editTextEmail.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            if(editTextSenha.text.toString().isEmpty()){
                editTextSenha.requestFocus()
                editTextSenha.setError("Campo obrigatorio")
                return@setOnClickListener
            }

            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }

        buttonVoltarCadastro.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }


    }
}
