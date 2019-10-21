package com.example.apprep

import android.media.Image
import android.widget.ImageView
import java.io.Serializable

data class Republica (var nome: String,
                      var rua: String,
                      var cep: String,
                      var bairro: String,
                      var num_residencia: String,
                      var foto_capa: ImageView? = null): Serializable