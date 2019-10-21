package com.example.apprep.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprep.R
import com.example.apprep.Republica
import com.example.apprep.adapter.RepublicaAdapter
import kotlinx.android.synthetic.main.activity_lista_de_republicas.*


class ListaRepublicasActivity : AppCompatActivity (){
    val repTest = Republica("mao de onze", "episcopal","147854589","centro", "4785" )
    val listaRepublica: MutableList<Republica> = mutableListOf(repTest)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_republicas)

        val novaRepublica: Republica? = intent.getSerializableExtra("novaRepublica2") as Republica
        if (novaRepublica != null) {
            listaRepublica.add(novaRepublica)
        }


        val adapter = RepublicaAdapter(this, listaRepublica)
        val layoutManager = LinearLayoutManager(this)

        rvRepublicas.adapter = adapter
        rvRepublicas.layoutManager = layoutManager
    }

}

