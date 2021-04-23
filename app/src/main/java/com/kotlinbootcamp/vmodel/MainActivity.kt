package com.kotlinbootcamp.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        initDados()
        initContador()
        initClick()

        validaContador()
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