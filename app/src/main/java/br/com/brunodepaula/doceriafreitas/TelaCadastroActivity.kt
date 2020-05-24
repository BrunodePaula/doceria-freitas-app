package br.com.brunodepaula.doceriafreitas

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_telacadastro.*

class TelaCadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telacadastro)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Adicionar Cliente"

        setTitle("Novo Cliente")

        salvarCliente.setOnClickListener {
            val clientes = Clientes()
            clientes.name = editNome.text.toString()
            clientes.telephone = editTelefone.text.toString()
            clientes.cpf = editCpf.text.toString()
            clientes.disabled = 0

            taskAtualizar(clientes)
        }

    }

    private fun taskAtualizar(clientes: Clientes) {
        // Thread para salvar a discilpina
        Thread {
            ClientesService.save(clientes)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}