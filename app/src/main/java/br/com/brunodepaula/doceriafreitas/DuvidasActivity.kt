package br.com.brunodepaula.doceriafreitas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pdfview.PDFView

class DuvidasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_duvidas)
        findViewById<PDFView>(R.id.activityMainPdfView).fromAsset("sample.pdf").show()
//        findViewById<PDFView>(R.id.activityMainPdfView).fromAsset("paper.pdf").show()
    }
}