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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicao_de_disponibilidade)

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
            val republicas: MutableList<Republica> = Paper.book().read(LISTA_REPUBLICAS) ?: mutableListOf()
            republicas.add(republica)
            Paper.book().write(LISTA_REPUBLICAS, republicas)
            val intent = Intent(this, ListaRepublicasActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonVoltarDisponibilidade.setOnClickListener {
            val intent = Intent(this, AdicaoFotoActivity::class.java)
            intent.putExtra(REPUBLICA, republica)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, AdicaoFotoActivity::class.java)
        intent.putExtra(REPUBLICA, republica)
        startActivity(intent)
        finish()
    }
}
