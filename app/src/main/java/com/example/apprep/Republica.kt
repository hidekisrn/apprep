package com.example.apprep

import java.io.Serializable

data class Republica (var nome: String,
                      var rua: String,
                      var cep: String,
                      var bairro: String,
                      var num_residencia: String,
                      var foto: String? = null): Serializable