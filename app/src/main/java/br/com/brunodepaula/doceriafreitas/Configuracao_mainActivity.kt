package br.com.brunodepaula.doceriafreitas

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

class Configuracao_mainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.configuracao_main)


        supportActionBar?.title = "Configurações"
    }
}