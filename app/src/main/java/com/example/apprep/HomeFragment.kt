package com.example.apprep


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.paperdb.Paper
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    var listaRepublica: List<Republica>? = null
        set(value) {
            field = value
            setAdapter(value)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }



//    override fun onResume() {
//        super.onResume()
//        listaRepublica = Paper.book().read(LISTA_REPUBLICAS) // Paper é uma lib para armazenar dados no dispositivo
//    }

    private fun setAdapter(list: List<Republica>?) {
        val adapter = activity?.let { RepublicaAdapter(it, listaRepublica ?: listOf()) }
//        adapter?.configuraClique {
//            val detalhesRepublica = Intent(activity, DetalhesRepublica::class.java)
//            detalhesRepublica.putExtra(REPUBLICA, it)
//            this.startActivity(detalhesRepublica)
//        }

        rvRepublicasFragment.adapter = adapter
        rvRepublicasFragment.layoutManager = LinearLayoutManager(activity)
    }
}
