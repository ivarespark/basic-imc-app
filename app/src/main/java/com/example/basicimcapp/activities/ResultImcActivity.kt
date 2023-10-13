package com.example.basicimcapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicimcapp.R

class ResultImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result = intent.extras?.getDouble("IMC_RESULT") ?: -1.0 // elvis es para mostrar valor si no tiene valor en extras
    }
}