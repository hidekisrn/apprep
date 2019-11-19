package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

//        usuario = intent.getSerializableExtra(USUARIO) as Usuario
//        usuario?.let {
//            //TODO: preencher campos com as informações que constam no objeto, por exemplo:
//            editTextNome.setText(it.nome ?: "")
//            editTextSobrenome.setText(it.sobrenome ?:"")
//            editTextTelefone.setText(it.telefone ?: "")
//            editTextCPF.setText(it.cpf ?: "")
//            editTextEmail.setText(it.email ?: "")
//            editTextSenha.setText(it.senha ?: "")
//            }

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

            val usuario: Usuario = Usuario(editTextNome.text.toString(), editTextSobrenome.text.toString(), editTextTelefone.text.toString(),
                editTextCPF.text.toString(), editTextEmail.text.toString(),editTextSenha.text.toString())
//            if(usuario == null) usuario = Usuario() // se estiver iniciando o cadatro cria uma nova republica
//            // usamos ?.let para tratar objetos nullables
//            usuario?.let {
//                it.nome = editTextNome.text.toString()
//                it.sobrenome = editTextSobrenome.text.toString()
//                it.telefone = editTextTelefone.text.toString()
//                it.cpf = editTextCPF.text.toString()
//                it.email = editTextEmail.toString()
//                it.senha = editTextSenha.toString()
//            }


            val usuarios: MutableList<Usuario> = Paper.book().read(LISTA_USUARIOS) ?: mutableListOf()
            usuarios.add(usuario)
            val index  = usuarios.indexOf(usuario)
            usuario.index = index
            usuarios[index] = usuario
            Paper.book().write(LISTA_USUARIOS, usuarios)
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }

        buttonVoltarCadastro.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }

        buttonFinalizarCadastro.setOnClickListener {
            val intent = Intent(this, ListaRepublicasActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, login::class.java)
        startActivity(intent)
        finish()
    }
}
