package com.example.apprep

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import java.io.Serializable

data class Republica(
    var nome: String,
    var rua: String,
    var cep: String,
    var bairro: String,
    var num_residencia: String,
    var foto: String? = null,
    var vagas: String? = null,
    var vagasCarro: String? = null,
    var banheiros: String? = null,
    var preco: String? = null): Serializable