package br.com.brunodepaula.doceriafreitas

import com.google.gson.GsonBuilder
import java.io.Serializable

class Estoque : Serializable{
    var name: String = ""
    var unity: String = ""
    var description: String = ""
    var price: String = ""
    var image: String = ""


    override fun toString(): String {
        return "Produto('$name')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}