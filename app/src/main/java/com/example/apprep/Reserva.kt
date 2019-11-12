package com.example.apprep

import java.io.Serializable

data class Reserva (
    var data_chegada: String? = null,
    var horario_chegada: String? = null,
    var data_saida: String? = null,
    var preco_total: String? = null,
    var nome_rep: String? = null,
    var foto_capa: String? = null): Serializable