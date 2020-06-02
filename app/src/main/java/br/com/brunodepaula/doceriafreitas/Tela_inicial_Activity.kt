package br.com.brunodepaula.doceriafreitas


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class Tela_inicial_Activity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this


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

        /*buttonPedidosDeVendas.setOnClickListener {
            var intent = Intent(this, TelaSecundariaActivity ::class.java)
            val button = buttonPedidosDeVendas.text.toString()
            val params = Bundle()

            params.putString("selecionado", button)
            intent.putExtras(params)


            startActivity(intent)
        }
        */

        buttonEstoque.setOnClickListener {
            var intent = Intent(this, EstoqueActivity ::class.java)

            val button = buttonEstoque.text.toString()
            val params = Bundle()

            params.putString("selecionado", button)
            intent.putExtras(params)


            startActivity(intent)
        }

        // colocar toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()


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

    // configuração do navigation Drawer com a toolbar
    private fun configuraMenuLateral() {
        // ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(this, layoutMenuLateral, toolbar, R.string.nav_open, R.string.nav_close)

        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    // método que deve ser implementado quando a activity implementa a interface NavigationView.OnNavigationItemSelectedListener
    // para tratar os eventos de clique no menu lateral
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_pedidos -> {
                Toast.makeText(this, "Clicou pedidos", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_localizacao -> {
                var intent = Intent(this, MapasActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_config -> {
                Toast.makeText(this, "Clicou configuração", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_duvidas -> {
                var intent = Intent(this, DuvidasActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_sair -> {
                Toast.makeText(this, "Clicou sair", Toast.LENGTH_SHORT).show()
                cliqueSair()
            }
        }

        // fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

}


