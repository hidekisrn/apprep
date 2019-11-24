package com.example.apprep

import java.io.Serializable

data class Reserva (
    var data_chegada: String? = null,
    var horario_chegada: String? = null,
    var data_saida: String? = null,
//    var preco_total: String? = null,
    var rua_reserva: String? = null,
    var cep_reserva: String? = null,
    var bairro_reserva: String? = null,
    var num_residencia_reserva: String? = null,
    var nome_reserva: String? = null,
    var foto_reserva: String? = null,
    var vagas_reserva: String? = null,
    var vagasCarro_reserva: String? = null,
    var banheiros_reserva: String? = null,
    var preco_reserva: String? = null,
    var descricao_reserva: String? = null,
    var usuario: Int = -1,
    var republica: String? = null): Serializable