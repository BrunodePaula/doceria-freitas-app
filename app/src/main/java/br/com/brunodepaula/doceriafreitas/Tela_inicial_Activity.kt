package br.com.brunodepaula.doceriafreitas


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class Tela_inicial_Activity : AppCompatActivity() {

    override  fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        bemVindo.text = "Bem vindo a Doceria Freitas!"

        buttonClientes.setOnClickListener {
            var intent = Intent(this, TelaSecundariaActivity ::class.java)
            val button = buttonClientes.text.toString()
            val params = Bundle()

            params.putString("selecionado", button)
            intent.putExtras(params)

            startActivity(intent)
        }

        buttonPedidosDeVendas.setOnClickListener {
            var intent = Intent(this, TelaSecundariaActivity ::class.java)
            val button = buttonPedidosDeVendas.text.toString()
            val params = Bundle()

            params.putString("selecionado", button)
            intent.putExtras(params)


            startActivity(intent)
        }

        buttonEstoque.setOnClickListener {
            var intent = Intent(this, TelaSecundariaActivity ::class.java)

            val button = buttonEstoque.text.toString()
            val params = Bundle()

            params.putString("selecionado", button)
            intent.putExtras(params)


            startActivity(intent)
        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    fun cliqueSair() {
        val returnIntent = Intent();
        returnIntent.putExtra("result","Saída do BrewerApp");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var intent = Intent(this, Configuracao_mainActivity ::class.java)
        var intent2 = Intent(this, TelaCadastroActivity ::class.java)
        val id = item?.itemId

        if(id == android.R.id.home){
            finish()
        }else if(id == R.id.action_config){
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }else if(id == R.id.action_adicionar){
              Toast.makeText(this, "Adicionar cliente", Toast.LENGTH_SHORT).show()
              startActivity(intent2)
        }else if(id == R.id.action_atualizar) {
            Toast.makeText(this, "Botão de atualizar", Toast.LENGTH_SHORT).show()
        }else if (id == R.id.action_sair) {
            finish()
        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}


