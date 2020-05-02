package br.com.brunodepaula.doceriafreitas

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.tela_secundaria.*

class TelaSecundariaActivity : AppCompatActivity() {

    private  val context: Context get() = this

    private var clientes = listOf<Clientes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_secundaria)
        val args = intent.extras
        val titulo = args?.getString("selecionado")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerClientes?.layoutManager = LinearLayoutManager(context)
        recyclerClientes?.itemAnimator = DefaultItemAnimator()
        recyclerClientes?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskClientes()
    }

    fun taskClientes() {
        clientes = ClientesService.getClientes(context)
        recyclerClientes?.adapter = ClientesAdapter(clientes) { onClickClientes(it) }
    }

    fun onClickClientes(clientes: Clientes) {
        Toast.makeText(context, "Clicou em ${clientes.nome}", Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
       if (id == android.R.id.home) {
            finish()
       }
        return super.onOptionsItemSelected(item)
    }

}