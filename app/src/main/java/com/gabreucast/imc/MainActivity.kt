package com.gabreucast.imc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private var currentWeight: Int = 80
    private var currentHeight: Int = 120
    private var currentAge: Int = 30

    private lateinit var cardMale: CardView
    private lateinit var cardFemale: CardView
    private lateinit var tvHeight: AppCompatTextView
    private lateinit var rlHeight: RangeSlider
    private lateinit var tvWeightValue: AppCompatTextView
    private lateinit var tvAgeValue: AppCompatTextView
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnCalculate: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
    }  // chave onCreate()

    private fun initListeners() {
        cardMale.setOnClickListener {
            cardMale.setCardBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.background_component_selected
                    )
                )
                cardFemale.setCardBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.background_component
                    )
                )

        }

        cardFemale.setOnClickListener {
            cardMale.setCardBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.background_component
                    )
                )
                cardFemale.setCardBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.background_component_selected
                    )
                )
        }

            rlHeight.addOnChangeListener { _, value, _ ->
                val currentHeight = value.toInt().toString()
                tvHeight.text = "$currentHeight Cm"
            }

            btnSubtractWeight.setOnClickListener {
                currentWeight -= 1
                tvWeightValue.text = currentWeight.toString()
            }

            btnAddWeight.setOnClickListener {
                currentWeight += 1
                tvWeightValue.text = currentWeight.toString()
            }

            btnSubtractAge.setOnClickListener {
                currentAge -= 1
                tvAgeValue.text = currentAge.toString()
            }

            btnAddAge.setOnClickListener {
                currentAge += 1
                tvAgeValue.text = currentAge.toString()
            }

        btnCalculate.setOnClickListener {
            //val result = calculateIMC()
            navigateToResult()
        }


        } // chave initListeners()


    private fun navigateToResult() {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("IMC_RESULT", calculateIMC())
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val imc = currentWeight / ((currentHeight / 100.0) * (currentHeight / 100.0))
        return imc
    }

    private fun initComponents() {
            cardMale = findViewById(R.id.cardMale)
            cardFemale = findViewById(R.id.cardFemale)
            tvHeight = findViewById(R.id.tvHeight)
            rlHeight = findViewById(R.id.rlHeight)
            tvWeightValue = findViewById(R.id.tvWeightValue)
            tvAgeValue = findViewById(R.id.tvAgeValue)
            btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
            btnAddWeight = findViewById(R.id.btnAddWeight)
            btnSubtractAge = findViewById(R.id.btnSubtractAge)
            btnAddAge = findViewById(R.id.btnAddAge)
            btnCalculate = findViewById(R.id.btnCalculate)
        } // chave initComponents()

    }// chave MainActivity
