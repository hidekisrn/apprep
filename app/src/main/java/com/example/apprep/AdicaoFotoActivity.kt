package com.example.apprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build.*
import kotlinx.android.synthetic.main.activity_adicao_de_foto.*

// PASSO 3
class AdicaoFotoActivity : AppCompatActivity() {

    lateinit var republica: Republica
    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_foto)

        usuario = intent.getSerializableExtra(USUARIO) as Usuario

        republica = intent.getSerializableExtra(REPUBLICA) as Republica
        if(republica.foto != null) fotoCapa.setImageURI(Uri.parse(republica.foto))

        //TODO: setar das outras fotos

        buttonAdicionarCapa.setOnClickListener {
            if (VERSION.SDK_INT >= VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){ //Se Permissão de acessar memoria externa recusada
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    requestPermissions(permissions, PERMISSION_CODE); //Popup para pedir acesso a galeria
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
            val abreLista = Intent(this, AdicaoDisponibilidadeActivity::class.java)
            abreLista.putExtra(REPUBLICA, republica)
            abreLista.putExtra(USUARIO, usuario)
            startActivity(abreLista)
            finish()
        }

        buttonVoltarFoto.setOnClickListener {
            val intent = Intent(this, AdicaoCaracteristicaActivity::class.java)
            intent.putExtra(REPUBLICA, republica)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, AdicaoCaracteristicaActivity::class.java)
        intent.putExtra(REPUBLICA, republica)
        intent.putExtra(USUARIO, usuario)
        startActivity(intent)
        finish()
    }

    private fun pickImageFromGallery() { //Metodo para pegar a imagem da galera
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
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
            republica.foto = data?.data.toString()
        }
    }
}
