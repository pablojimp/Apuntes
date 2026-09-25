package com.example.pmdmud1.e02

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//Ampliación voluntaria
//Añade un campo «Descuento en euros» (Double) y comprueba que no supera el total; muestra el
//importe final.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val precio = findViewById<EditText>(R.id.etPrecio)
        val cantidad = findViewById<EditText>(R.id.etCantidad)
        val descuento = findViewById<EditText>(R.id.etDescuento)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val boton = findViewById<Button>(R.id.btnTicket)

        boton.setOnClickListener {
            val precioDato: Double? = precio.text.toString().toDoubleOrNull()
            val cantidadDato : Int? = cantidad.text.toString().toIntOrNull()
            val cantidadDescuento: Double? = descuento.text.toString().toDoubleOrNull()
            if (precioDato == null || cantidadDato == null){
                resultado.text = "Verifica los campos que has introducido"
            }else{
                if (precioDato >= 0 && cantidadDato > 0 ){
                    var total: Double = precioDato * cantidadDato
                    if(cantidadDescuento != null){
                        if (total < cantidadDescuento){
                            resultado.text = "El descuento no puede superar el total"
                        }else{
                            total -= cantidadDescuento
                            resultado.text = "El total es ${total}€"
                        }
                    }else {
                        resultado.text = "El total es ${total}€"
                    }
                }else{
                    resultado.text = "Introduce números válidos"
                }
            }
        }
    }
}
