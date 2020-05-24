package br.com.brunodepaula.doceriafreitas

import android.app.Application
import java.lang.IllegalStateException

class DoceriaApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: DoceriaApplication? = null

        fun getInstance(): DoceriaApplication {
            if (appInstance == null) {
                throw  IllegalStateException("Configurar application no Android Manifest")
            }
            return  appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}