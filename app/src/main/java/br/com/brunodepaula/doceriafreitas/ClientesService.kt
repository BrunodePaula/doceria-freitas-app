package br.com.brunodepaula.doceriafreitas

import android.content.Context

object ClientesService {

    fun getClientes(context: Context): List<Clientes> {
        val clientes = mutableListOf<Clientes>()

        for (i in 1..10) {
            val c = Clientes()
            c.nome = "Cliente $i"
            c.foto = "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"
            clientes.add(c)
        }

        return  clientes
    }
}