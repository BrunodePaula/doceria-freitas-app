package br.com.brunodepaula.doceriafreitas

import com.google.gson.GsonBuilder
import java.io.Serializable

class Clientes : Serializable{
    var name: String = ""
    var cpf: String = ""
    var telephone: String = ""
    var email: String = ""
    var disabled: String = ""


    override fun toString(): String {
        return "Cliente(nome='$name')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}