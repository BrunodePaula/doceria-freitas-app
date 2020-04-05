package br.com.brunodepaula.doceriafreitas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TelaCadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telacadastro)

        supportActionBar?.title = "Adicionar Cliente"
    }

}