package com.example.conteo_electoral

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.app.AlertDialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val inputNombre = findViewById<EditText>(R.id.inpNombre)
        val inputEdad = findViewById<EditText>(R.id.inpEdad)
        val btnValidar = findViewById<Button>(R.id.btnValidar)

        btnValidar.setOnClickListener {
            val nombre = inputNombre.text.toString()
            val edad = inputEdad.text.toString()
            val enviar = Intent(this, VotacionActivity::class.java)
            val totalElectores = findViewById<EditText>(R.id.inpTotalElectores).text.toString()
            enviar.putExtra("total", totalElectores)
            startActivity(enviar)


            if(nombre.isEmpty() || edad.isEmpty()){
                Toast.makeText(this, "Por favor completa los campos", Toast.LENGTH_SHORT).show()
            }else{
                val edad  = edad.toInt()

                if(edad >= 18){
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("Informacion correcta")
                    alert.setMessage("Hola $nombre, puedes votar")
                    alert.setPositiveButton("Ir a votar") { _, _ -> // Añade esto
                        val intent = Intent(this, VotacionActivity::class.java)
                        startActivity(intent)
                    }
                    alert.show()
                }else{
                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("Acceso Denegado")
                    alert.setMessage("$nombre No tienes la edad suficiente para votar.")
                    alert.setPositiveButton("Ok", null)
                    alert.show()
                }
            }
        }
    }
}