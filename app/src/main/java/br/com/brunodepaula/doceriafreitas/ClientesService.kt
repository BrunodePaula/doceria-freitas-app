package br.com.brunodepaula.doceriafreitas

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object ClientesService {

    val host = "http://doceriafreitas-com-br.umbler.net"
    //val host = "https://fesousa.pythonanywhere.com"
    val TAG = "WS_LMSApp"

    fun getClientes(context: Context): List<Clientes> {
        if(AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/clients"
            val json = HttpHelper.get(url)

            Log.d(TAG, json)

            return parserJson<List<Clientes>>(json)
        }else {
            return ArrayList()
        }
    }

    fun save(clientes: Clientes): Response {
        val json = HttpHelper.post("$host/clients", clientes.toJson())
        return parserJson(json)
    }

    inline fun<reified  T> parserJson(json: String) : T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}