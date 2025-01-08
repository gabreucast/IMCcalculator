package com.gabreucast.imc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

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

    @SuppressLint("DefaultLocale", "UseCompatLoadingForDrawables")
    private fun mostrarResultado() {
        initListeners()

        imc = intent.getDoubleExtra("IMC_RESULT",0.0)
        val formattedImc = String.format("%.2f", imc)
        val isMale = intent.getBooleanExtra("CARD_RESULT", true)
        tvIMC.text = formattedImc
        when {
            imc < 18.5 -> {
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.background = getDrawable(R.color.peso_bajo)
                tvDescription.text = if (isMale) getString(R.string.description_bajo_peso_men) else getString(R.string.description_bajo_peso_women)
            }
            imc in 18.5..24.9 -> {
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.background = getDrawable(R.color.peso_normal)
                tvDescription.text = if (isMale) getString(R.string.description_peso_normal_men) else getString(R.string.description_peso_normal_women)
            }
            imc in 25.0..29.9 -> {
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.background = getDrawable(R.color.peso_sobrepeso)
                tvDescription.text = if (isMale) getString(R.string.description_sobrepeso_men) else getString(R.string.description_sobrepeso_women)
            }
            else -> {
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.background = getDrawable(R.color.obesidad)
                tvDescription.text = if (isMale) getString(R.string.description_obesidad_men) else getString(R.string.description_obesidad_women)
            }
        }

    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
            finish()
        }
    }

    private fun initComponents() {
        tvTitle = findViewById(R.id.tvTitle)
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)

    }
} // chave do ResultadoActivity