package br.com.brunodepaula.doceriafreitas

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    val TAG = "FIREBASE_DOCERIA"

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "Novo Token: $token")

        Prefs.setString("FB_TOKEN", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived")

        if(mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            var corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Título: $titulo")
            Log.d(TAG, "Corpo: $corpo")

            if(mensagemRemota?.data.isNotEmpty()) {
                val clienteId = mensagemRemota.data.get("clienteId")
                corpo = "$corpo ($clienteId)"
            }

            val intent = Intent(this, TelaSecundariaActivity::class.java)
            NotificationUtil.create(this, 1, intent, titulo!!, corpo!!)
        }
    }
}