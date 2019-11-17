package com.example.apprep

import java.io.Serializable

data class Republica(
    var rua: String,
    var cep: String,
    var bairro: String,
    var num_residencia: String,
    var nome: String? = null,
    var foto: String? = null,
    var vagas: String? = null,
    var vagasCarro: String? = null,
    var banheiros: String? = null,
    var preco: String? = null,
    var descricao: String? = null): Serializable