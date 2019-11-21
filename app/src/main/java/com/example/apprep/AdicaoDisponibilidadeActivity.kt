package com.example.apprep

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_adicao_de_disponibilidade.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

//PASSO 4
class AdicaoDisponibilidadeActivity : AppCompatActivity() {

    lateinit var republica: Republica
    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_disponibilidade)

        usuario = intent.getSerializableExtra(USUARIO) as Usuario

        republica = intent.getSerializableExtra(REPUBLICA) as Republica

        //TODO: Mover para um utilitários
        val calendario = Calendar.getInstance()
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val data = LocalDateTime.now()
        dataInicioDisponibilidade.setText(data.format(DateTimeFormatter.ofPattern(" d/M/y ")))
        dataTerminoDisponibilidade.setText(data.format(DateTimeFormatter.ofPattern(" d/M/y ")))


        dataInicioDisponibilidade.setOnClickListener {
            val dataInicio = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, iAno, iMes, iDia ->
                dataInicioDisponibilidade.setText(" " +iDia + "/" + iMes + "/" + iAno + " ")
            }
                , ano, mes, dia)
            dataInicio.show()
        }

        dataTerminoDisponibilidade.setOnClickListener {
            val dataTermino = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, tAno, tMes, tDia ->
                dataTerminoDisponibilidade.setText(" " +tDia + "/" + tMes + "/" + tAno + " ")
            }
            , ano, mes, dia)
            dataTermino.show()
        }

        buttonFinalizar.setOnClickListener {
            //salva as republicas na memoria do dispositivo e fecha o cadastro
            republica.usuario = usuario.index
            val republicas: MutableList<Republica> = Paper.book().read(LISTA_REPUBLICAS) ?: mutableListOf()
            republicas.add(republica)
            Paper.book().write(LISTA_REPUBLICAS, republicas)
            val index = republicas.indexOf(republica)
            usuario.republica = index
            val usuarios: MutableList<Usuario> = Paper.book().read(LISTA_USUARIOS) ?: mutableListOf()
            val index2 = usuarios.indexOf(usuario)
            usuarios[usuario.index] = usuario
            Paper.book().write(LISTA_USUARIOS, usuarios)
            val intent = Intent(this, ListaRepublicasActivity::class.java)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }

        buttonVoltarDisponibilidade.setOnClickListener {
            val intent = Intent(this, AdicaoFotoActivity::class.java)
            intent.putExtra(REPUBLICA, republica)
            intent.putExtra(USUARIO, usuario)
            startActivity(intent)
            finish()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, AdicaoFotoActivity::class.java)
        intent.putExtra(REPUBLICA, republica)
        intent.putExtra(USUARIO, usuario)
        startActivity(intent)
        finish()
    }
}
