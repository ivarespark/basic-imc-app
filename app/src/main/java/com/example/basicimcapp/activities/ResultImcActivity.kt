package com.example.basicimcapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.basicimcapp.R
import com.example.basicimcapp.activities.ImcCalculatorActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {

    private lateinit var tvImcLevel: TextView
    private lateinit var tvImcValue: TextView
    private lateinit var tvImcDescription: TextView
    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0 // elvis es para mostrar valor si no tiene valor en extras
        initComponents()
        initListeners()
        initValues(result)
    }

    private fun initComponents() {
        tvImcLevel = findViewById(R.id.tvImcLevel)
        tvImcValue = findViewById(R.id.tvImcValue)
        tvImcDescription = findViewById(R.id.tvImcDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener{
            // Volver a pantalla anterior
        }
    }

    private fun initValues(result: Double) {
        tvImcValue.text = result.toString()
    }
}