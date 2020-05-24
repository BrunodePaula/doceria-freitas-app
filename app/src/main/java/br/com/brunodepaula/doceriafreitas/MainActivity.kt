package br.com.brunodepaula.doceriafreitas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imageViewPrincipal.setImageResource(R.drawable.img_login)

        //texto_login.text = getString(R.string.mensagem_login)

        // evento no botao de login forma 1
//        botao_login.setOnClickListener {
//            val valorUsuario = campo_usuario.text.toString()
//            val valorSenha = campo_senha.text.toString()
//            Toast.makeText(this, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()
//        }

        // segunda forma: delegar para método
        buttonLogin.setOnClickListener {onClickLogin() }

        //progressBar.visibility = View.INVISIBLE

        // procurar pelas preferências, se pediu para guardar usuário e senha
        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome  = Prefs.getString("lembrarNome")
            var lembrarSenha  = Prefs.getString("lembrarSenha")
            usuario.setText(lembrarNome)
            senha.setText(lembrarSenha)
            checkLembrar.isChecked = lembrar

        }


    }

    fun onClickLogin(){

        val valorUsuario = usuario.text.toString()
        val valorSenha = senha.text.toString()

        // armazenar valor do checkbox
        Prefs.setBoolean("lembrar", checkLembrar.isChecked)
        // verificar se é para pembrar nome e senha
        if (checkLembrar.isChecked) {
            Prefs.setString("lembrarNome", valorUsuario)
            Prefs.setString("lembrarSenha", valorSenha)
        } else{
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha", "")
        }


        // criar intent
        val intent = Intent(context, Tela_inicial_Activity::class.java)
        // colocar parâmetros (opcional)
        val params = Bundle()
        params.putString("nome", "Fernando Sousa")
        intent.putExtras(params)

        // enviar parâmetros simplificado
        intent.putExtra("numero", 10)

        // fazer a chamada
        //startActivity(intent)

        // fazer a chamada esperando resultado
        startActivityForResult(intent, 1)

    }
}
