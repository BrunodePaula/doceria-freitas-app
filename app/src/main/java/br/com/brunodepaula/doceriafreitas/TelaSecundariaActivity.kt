package br.com.brunodepaula.doceriafreitas

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class TelaSecundariaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_secundaria)
        val args = intent.extras
        val titulo = args?.getString("selecionado")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
       if (id == android.R.id.home) {
            finish()
       }
        return super.onOptionsItemSelected(item)
    }

}