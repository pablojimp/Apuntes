package com.example.pmdmud1.ej7

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val entrada1 = findViewById<EditText>(R.id.etNumero1)
        val entrada2 = findViewById<EditText>(R.id.etNumero2)
        var resultado = findViewById<TextView>(R.id.tvResultado)
        val botonSumar = findViewById<Button>(R.id.btnSumar)
        val botonRestar = findViewById<Button>(R.id.btnRestar)
        val botonMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val botonDividir = findViewById<Button>(R.id.btnDividir)


        fun calcular(operacion: String): String {
            var resultado = ""
            val numero1Convertido = entrada1.text.toString().toDoubleOrNull()
            val numero2Convertido = entrada2.text.toString().toDoubleOrNull()

            if(operacion == "/" && numero2Convertido == 0.0){
                resultado = "No se puede dividir entre 0"

            }else if(numero1Convertido == null || numero2Convertido == null){

                resultado = "Deben estar los numero completos"

            }else{
                when (operacion) {
                    "+" -> resultado = (numero1Convertido + numero2Convertido).toString()
                    "-" -> resultado = (numero1Convertido - numero2Convertido).toString()
                    "*" -> resultado = (numero1Convertido * numero2Convertido).toString()
                    "/" -> resultado = (numero1Convertido / numero2Convertido).toString()
                }
            }

            return resultado;

            // TODO 1: convierte los dos números y valida la entrada.
            // TODO 2: evita dividir entre cero.
            // TODO 3: calcula con when y muestra el resultado.
        }

        botonSumar.setOnClickListener {
            resultado.text = calcular("+")
        }

        botonRestar.setOnClickListener {
            resultado.text = calcular("-")
        }
        botonDividir.setOnClickListener {
            resultado.text = calcular("/")
        }
        botonMultiplicar.setOnClickListener {
            resultado.text = calcular("*")
        }





    }
}
