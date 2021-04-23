package com.kotlinbootcamp.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etContador: EditText
    lateinit var btnContador: Button
    lateinit var btnMostrar: Button

    var contador : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayLog(state = "onCreate Activity")
        initDados()
        initContador()
        initClick()

        validaContador()
    }

    override fun onStart() {
        super.onStart()
        displayLog(state = "onStart Activity")
    }

    override fun onResume() {
        super.onResume()
        displayLog(state = "onResume Activity")
    }

    override fun onPause() {
        super.onPause()
        displayLog(state = "onPause Activity")
    }

    override fun onStop() {
        super.onStop()
        displayLog(state = "onStop Activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        displayLog(state = "onDestroy Activity")
    }

    private fun displayLog(tag:String="CycleLifeActivity",state:String){
        Log.d(tag,state)
    }


    private fun validaContador() {
        if(contador > 5){
            contador = 0
        }
    }

    private fun initClick() {
        btnContador.setOnClickListener {
            contador++
            validaContador()
            initContador()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(this, "Valor do Contador: ${contador.toString()}",Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun initContador() {
        etContador.setText(contador.toString())
    }

    private fun initDados() {
        etContador = findViewById(R.id.etContador)
        btnContador = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)
    }
}