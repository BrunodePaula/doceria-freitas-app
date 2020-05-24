package br.com.brunodepaula.doceriafreitas

import com.google.gson.GsonBuilder

class Clientes {
    var name: String = ""
    var cpf: String = ""
    var telephone: String = ""
    var email: String = ""


    override fun toString(): String {
        return "Cliente(nome='$name')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}