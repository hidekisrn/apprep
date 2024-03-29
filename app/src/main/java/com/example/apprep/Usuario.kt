package com.example.apprep

import java.io.Serializable

data class Usuario (
    var nome: String? = null,
    var sobrenome: String? = null,
    var telefone: String? = null,
    var cpf: String? = null,
    var email: String? = null,
    var senha: String? = null,
    var index: Int = -1,
    var republica: Int = -1): Serializable