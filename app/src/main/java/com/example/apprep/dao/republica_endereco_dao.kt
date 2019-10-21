package com.example.apprep.dao

import com.example.apprep.model.republica_endereco_model

class republica_endereco_dao {
    companion object{
        private val enderecos: MutableList<republica_endereco_model> = mutableListOf()
    }

    fun all (): List<republica_endereco_model> {
        return enderecos
    }

    fun add(vararg endereco: republica_endereco_model){
        enderecos.addAll(endereco)
    }

}
