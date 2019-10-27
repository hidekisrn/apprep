package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_perfil.*

class perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        adicionarRepublica.setOnClickListener {
            val intent = Intent(this, AdicaoEnderecoActivity::class.java)
            startActivity(intent)
        }
    }
}
