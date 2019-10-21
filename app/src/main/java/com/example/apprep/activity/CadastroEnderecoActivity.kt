package com.example.apprep.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprep.R
import com.example.apprep.Republica
import kotlinx.android.synthetic.main.activity_adicao_de_caracteristica.*
import kotlinx.android.synthetic.main.activity_cadastro_endereco.*

class CadastroEnderecoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_endereco)

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


               /* val republica = Republica (editTextCEP.text.toString(),
                    editTextRua.text.toString(),
                    editTextNumeroResidencia.text.toString(),
                    editTextBairro.text.toString())
*/
            val republica = Republica("",editTextRua.text.toString(), editTextCEP.text.toString(),
                editTextBairro.text. toString(), editTextNumeroResidencia.text.toString())

            val intent = Intent(this, AdicaoCaracteristicaActivity::class.java)
            intent.putExtra("novaRepublica", republica)
            startActivity(intent)
        }
    }
}
