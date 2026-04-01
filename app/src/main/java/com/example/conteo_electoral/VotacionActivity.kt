package com.example.conteo_electoral

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlin.random.Random

class VotacionActivity: ComponentActivity() {

    var votosRealizados = 0
    var limiteVotantes = 0
    var candidatoSeleccionado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.votacion_activity)

        val totalVotantes = intent.getStringExtra("total")
        limiteVotantes = totalVotantes?.toInt() ?: 0

        val salomon = findViewById<Button>(R.id.btnFeid)
        val juan = findViewById<Button>(R.id.btnMaluma)
        val carolina = findViewById<Button>(R.id.btnKarol)
        val finalizr = findViewById<Button>(R.id.btnFinalizar)

        salomon.setOnClickListener {
            if(votosRealizados < limiteVotantes){
                candidatoSeleccionado = "Salomon Villada"
                votosRealizados++
                Toast.makeText(this, "Señor usuario, su voto fue para Salomon Villada", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Voto $votosRealizados de $limiteVotantes registrado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Ya votaron todos los electores", Toast.LENGTH_LONG).show()
            }
        }

        juan.setOnClickListener {
            if(votosRealizados < limiteVotantes){
                candidatoSeleccionado = "Juan Luis Londoño"
                votosRealizados++
                Toast.makeText(this, "Señor usuario, su voto fue para Juan Luis Londoño", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Ya votaron todos los electores", Toast.LENGTH_LONG).show()
            }

        }

        carolina.setOnClickListener {
            if(votosRealizados < limiteVotantes){
                candidatoSeleccionado = "Carolina Giraldo"
                votosRealizados++
                Toast.makeText(this, "Señor usuario, su voto fue para Carolina Giraldo", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Voto $votosRealizados de $limiteVotantes registrado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Ya votaron todos los electores", Toast.LENGTH_LONG).show()
            }
        }

        finalizr.setOnClickListener {
            if(candidatoSeleccionado == ""){
                Toast.makeText(this, "Señor usuario, por favor vote por un candidato", Toast.LENGTH_SHORT).show()
            }else if(votosRealizados < limiteVotantes){
                Toast.makeText(this, "Faltan personas por votar", Toast.LENGTH_SHORT).show()
            }else{
                mostrarResultado()
            }
        }
    }

    private fun mostrarResultado() {
        val canidatos = listOf("Salomon Villada", "Juan Luis Londoño", "Carolina Giraldo")
        val ganador =canidatos.random()
        val votos = Random.nextInt(500, 5000)

        val alert = AlertDialog.Builder(this)

        alert.setTitle("Conteo final...")

        alert.setMessage("El candidato ganor es: $ganador \n" + "Con un total de $votos votos.")

        alert.setPositiveButton("Cerrar votaciones"){_, _ ->
            finish()
        }

        alert.show()
    }
}