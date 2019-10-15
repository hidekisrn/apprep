package com.example.apprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprep.activity.CadastroEnderecoActivity

import kotlinx.android.synthetic.main.activity_perfil.*

class perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        adicionarRepublica.setOnClickListener {
            val intent = Intent(this, CadastroEnderecoActivity::class.java)
            startActivity(intent)
        }
    }
}
