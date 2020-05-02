package br.com.brunodepaula.doceriafreitas

class Clientes {
    var id: Long = 0
    var nome: String = ""
    var foto: String = ""

    override fun toString(): String {
        return "Cliente(nome='$nome')"
    }
}