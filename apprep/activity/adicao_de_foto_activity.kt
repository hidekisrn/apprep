package com.example.apprep.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build.*
import com.example.apprep.R
import kotlinx.android.synthetic.main.activity_adicao_de_caracteristica.*
import kotlinx.android.synthetic.main.activity_adicao_de_foto.*

class adicao_de_foto_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_foto)

      //  val novaRepublica: String? = intent.getStringExtra("novaRepublica")


        buttonAdicionarCapa.setOnClickListener {
            if (VERSION.SDK_INT >= VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){ //Se Permissão de acessar memoria externa recusada
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    requestPermissions(permissions,
                        PERMISSION_CODE
                    ); //Popup para pedir acesso a galeria
                }
                else{
                    //se já tiver permissão
                    pickImageFromGallery();
                }
            }
            else{
                //se o SO for inferior ao Marshmallow
                pickImageFromGallery();
            }
        }

        buttonProximoFoto.setOnClickListener {
            val abreLista = Intent(this, ListaRepublicasActivity::class.java)
            abreLista.putExtra("nomeRepublica", editTextNomedaRepublica.text.toString())
            startActivity(abreLista)
            /*val intent = Intent(this, adicao_de_disponibilidade_activity::class.java)
            startActivity(intent)*/



        }

    }

    private fun pickImageFromGallery() { //Metodo para pegar a imagem da galera
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent,
            IMAGE_PICK_CODE
        )
    }

    companion object {
        //Código para "pegar" imagem da galeria = 1000
        private val IMAGE_PICK_CODE = 1000;
        //Código de permissão do usuário = 1001
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //Permissão da tela de "aceitar ou recusar" acesso a galeria aceita
                    pickImageFromGallery()
                }
                else{
                    //Permissão da tela de "aceitar ou recusar" acesso a galeria recusada
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            fotoCapa.setImageURI(data?.data)
        }
    }
}
