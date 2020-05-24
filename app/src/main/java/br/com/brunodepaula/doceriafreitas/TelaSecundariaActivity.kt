package br.com.brunodepaula.doceriafreitas

import android.content.Context
import android.content.Intent
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
        Thread {
            this.clientes = ClientesService.getClientes(context)
            runOnUiThread {
                recyclerClientes?.adapter = ClientesAdapter(clientes) { onClickClientes(it) }
                enviaNotificacao(clientes.get(0))
            }
        }.start()
    }

    fun enviaNotificacao(clientes: Clientes) {
        // Intent para abrir tela quando clicar na notificação
        val intent = Intent(this, TelaSecundariaActivity::class.java)
        // parâmetros extras
        intent.putExtra("clientes", clientes)
        // Disparar notificação
        NotificationUtil.create(this, 1, intent, "Doceria Freitas", "Você tem um novo cliente: ${clientes.name}")
    }

    fun onClickClientes(clientes: Clientes) {
        Toast.makeText(context, "Cliente: ${clientes.name}", Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
       if (id == android.R.id.home) {
            finish()
       }
        return super.onOptionsItemSelected(item)
    }

}