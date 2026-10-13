package com.example.ej8

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    fun saldo(ingresos: Double,comida: Double,transporte: Double): Double{
            var total = ingresos - comida - transporte

        return TODO("Provide the return value")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ingresos = findViewById<EditText>(R.id.etIngresos)
        val comida = findViewById<EditText>(R.id.etComida)
        val transporte = findViewById<EditText>(R.id.etTransporte)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val calcular = findViewById<Button>(R.id.btnCalcular)

        calcular.setOnClickListener {
            val ingresosNumero = ingresos.text.toString().toDoubleOrNull()
            val comidaNumero = comida.text.toString().toDoubleOrNull()
            val transporteNumero = transporte.text.toString().toDoubleOrNull()
            // TODO 2: convierte las tres entradas y comprueba los errores.
            // TODO 3: llama a saldo y clasifica su valor mediante when.
            // TODO 4: muestra el resultado.
        }
        // TODO 5: crea btnLimpiar en XML y programa su listener.
    }
}
