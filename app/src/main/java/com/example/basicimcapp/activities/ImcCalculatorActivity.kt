package com.example.basicimcapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.basicimcapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 50
    private var currentAge:Int = 18

    // lateinit para inicializar luego
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var tvWeight:TextView
    private lateinit var btnLessWeight:FloatingActionButton
    private lateinit var btnMoreWeight:FloatingActionButton
    private lateinit var tvAge:TextView
    private lateinit var btnLessAge:FloatingActionButton
    private lateinit var btnMoreAge:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnLessWeight = findViewById(R.id.btnLessWeight)
        btnMoreWeight = findViewById(R.id.btnMoreWeight)
        btnLessAge = findViewById(R.id.btnLessAge)
        btnMoreAge = findViewById(R.id.btnMoreAge)
    }

    private fun initListeners() {
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor() }
        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor() }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##") // formateo el decimal
            tvHeight.text = df.format(value).toString() // muestro el valor sin decimales
        }
        btnLessWeight.setOnClickListener{ setWeight(-1) }
        btnMoreWeight.setOnClickListener{ setWeight(1)}
        btnLessAge.setOnClickListener{ setAge(-1)}
        btnMoreAge.setOnClickListener{ setAge(1)}
    }

    private fun setAge(ind:Int) {
        currentAge += ind
        tvAge.text = currentAge.toString()
    }

    private fun setWeight(ind:Int) {
        currentWeight += ind
        tvWeight.text = currentWeight.toString()
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent:Boolean):Int{
        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }
        return ContextCompat.getColor(this,colorReference)
    }

    private fun initUI(){
        setGenderColor()
        setWeight(0)
        setAge(0)
    }
}