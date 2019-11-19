package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val usuario = intent.getSerializableExtra(USUARIO) as Usuario

        adicionarRepublica.setOnClickListener {
            val intent = Intent(this, CadastraEnderecoActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }
    }
}
