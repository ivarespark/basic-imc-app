package com.example.basicimcapp.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0 // elvis es para mostrar valor si no tiene valor en extras
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
            onBackPressed()
        }
    }

    private fun initValues(result: Double) {
        tvImcValue.text = result.toString()
        when(result){
            in 0.00..18.50 -> {
                tvImcLevel.text = getString(R.string.low_level)
                tvImcLevel.setTextColor(ContextCompat.getColor(this, R.color.low_color))
                tvImcDescription.text = getString(R.string.low_description)
            }
            in 18.51..24.99 -> {
                tvImcLevel.text = getString(R.string.normal_level)
                tvImcLevel.setTextColor(ContextCompat.getColor(this, R.color.normal_color))
                tvImcDescription.text = getString(R.string.normal_description)
            }
            in 25.00..29.99 -> {
                tvImcLevel.text = getString(R.string.high_level)
                tvImcLevel.setTextColor(ContextCompat.getColor(this, R.color.high_color))
                tvImcDescription.text = getString(R.string.high_description)
            }
            in 30.00..99.99 -> {
                tvImcLevel.text = getString(R.string.over_level)
                tvImcLevel.setTextColor(ContextCompat.getColor(this, R.color.over_color))
                tvImcDescription.text = getString(R.string.over_description)
            }
            else -> {
                tvImcLevel.text = getString(R.string.error)
                tvImcLevel.setTextColor(ContextCompat.getColor(this, R.color.white))
                tvImcValue.text = getString(R.string.error)
                tvImcDescription.text = getString(R.string.error)
            }
        }

    }
}