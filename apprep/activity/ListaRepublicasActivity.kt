package com.example.apprep.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprep.R
import com.example.apprep.adapter.RepublicaAdapter
import kotlinx.android.synthetic.main.activity_lista_de_republicas.*


class ListaRepublicasActivity : AppCompatActivity (){

    val listaRepublica: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_republicas)

        val novaRepublica: String? = intent.getStringExtra("novaRepublica")
        if (novaRepublica != null) {
            listaRepublicas.add(novaRepublica)
        }


        val adapter = RepublicaAdapter(listaRepublicas)
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, layoutManager.orientation)

        rvRepublicas.adapter = adapter
        rvRepublicas.layoutManager = layoutManager
        rvRepublicas.addItemDecoration(dividerItemDecoration)
    }

}

