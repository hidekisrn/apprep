package com.example.apprep

import java.io.Serializable

data class Republica(
    var rua: String? = null,
    var cep: String? = null,
    var bairro: String? = null,
    var num_residencia: String? = null,
    var nome: String? = null,
    var foto: String? = null,
    var vagas: String? = null,
    var vagasCarro: String? = null,
    var banheiros: String? = null,
    var preco: String? = null,
    var descricao: String? = null,
    var avaliacaoMedia: Float = 0F,
    var avaliacaoSoma: Float = 0F,
    var countAvaliacao: Int = 0,
    var usuario: Int = 0,
    var reserva: Int? = null): Serializable