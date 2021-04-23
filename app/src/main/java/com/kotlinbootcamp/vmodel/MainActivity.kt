package com.kotlinbootcamp.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var etContador: EditText
    lateinit var btnContador: Button
    lateinit var btnMostrar: Button

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClick()

    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        etContador = findViewById(R.id.etContador)
        btnContador = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        mViewModel.nContador.observe(this, Observer {valor ->
            etContador.setText(valor)
        })
    }



    private fun initClick() {
        btnContador.setOnClickListener {
            mViewModel.contador()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(applicationContext, "Valor do Contador: ${mViewModel.nContador.value}",Toast.LENGTH_SHORT).show()
        }
    }
}