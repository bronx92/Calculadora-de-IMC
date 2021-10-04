package com.bronx92.imccalc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var pesoEditText: EditText
    lateinit var alturaEditText: EditText
    lateinit var resultadoTextView: TextView
    lateinit var calcularButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Cálculo de IMC"
        pesoEditText = findViewById(R.id.pesoEditText)
        alturaEditText = findViewById(R.id.alturaEditText)
        calcularButton = findViewById(R.id.calcularButton)
        resultadoTextView = findViewById(R.id.resultadoTextView)
        setListeners()
    }

    private fun setListeners(){
        calcularButton.setOnClickListener {
            calcularIMC(pesoEditText.text.toString(), alturaEditText.text.toString())
        }

    }
     fun calcularIMC(peso: String, altura: String) {
        val peso = peso.replace(",",".").toDoubleOrNull()
        val altura = altura.replace(",",".").toDoubleOrNull()
        val imc: Float
         if (peso != null && altura != null) {
            imc = (peso / (altura * altura)).toFloat()
             resultadoTextView.text = getString(R.string.imc_resultado).format(imc)
        } else {
            null
         }

    }



}