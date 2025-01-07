package com.gabreucast.imc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    private var imc: Double = 0.0


    private lateinit var tvTitle : AppCompatTextView
    private lateinit var tvResult : AppCompatTextView
    private lateinit var tvIMC : AppCompatTextView
    private lateinit var tvDescription : AppCompatTextView
    private lateinit var btnRecalculate : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        initComponents()
        mostrarResultado()
    }

    private fun mostrarResultado() {
        val valor = intent.getDoubleExtra("IMC_RESULT",0.0)
        tvIMC.text = valor.toString()
//        when {
//            imc < 18.5 -> {
//                tvTitle.text = getString("R.string.title_low_weight")
//                tvDescription.text = getString(R.string.description_low_weight)
//            }
//
//        }
    }

    private fun initComponents() {
        tvTitle = findViewById(R.id.tvTitle)
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)

    }
} // chave do ResultadoActivity