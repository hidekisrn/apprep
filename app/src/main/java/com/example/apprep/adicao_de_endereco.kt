package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_adicao_de_endereco.*

class adicao_de_endereco : AppCompatActivity() {

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

            val intent = Intent(this, adicao_de_caracteristica::class.java)
            startActivity(intent)
        }
    }
}
