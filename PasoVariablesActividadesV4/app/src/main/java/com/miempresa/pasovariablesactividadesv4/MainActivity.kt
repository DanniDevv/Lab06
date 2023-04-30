package com.miempresa.pasovariablesactividadesv4

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtseleccionados.isFocusable = false
        val values = arrayOf(
            "Juegos",
            "Aplicaciones",
            "Cursos",
            "Profesores",
            "Cerrar"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, android.R.id.text1,
            values
        )

        lista.adapter = adapter

        lista.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val itemPosition = position
                val itemValue = lista.getItemAtPosition(position) as String
                val seleccionados = txtseleccionados.text.toString()
                when (itemValue) {
                    "Juegos" -> {
                        val intent = Intent(this, juegos::class.java)
                        intent.putExtra("seleccionados", seleccionados)
                        this.finish()
                        startActivity(intent)
                    }
                    "Aplicaciones" ->{
                        val intent = Intent(this, Aplicacion::class.java)
                        intent.putExtra("seleccionados", seleccionados)
                        this.finish()
                        startActivity(intent)
                    }
                    "Cursos" -> {
                        val intent = Intent(this, Cursos::class.java)
                        intent.putExtra("seleccionados", seleccionados)
                        this.finish()
                        startActivity(intent)
                    }
                    "Profesores" -> {
                        val intent = Intent(this, Profesores::class.java)
                        intent.putExtra("seleccionados", seleccionados)
                        this.finish()
                        startActivity(intent)
                    }
                    "Cerrar"->{
                        AlertDialog.Builder(this)
                            .setTitle("Cerrar aplicación")
                            .setMessage("¿Está seguro que desea cerrar la aplicación?")
                            .setPositiveButton("Sí") { _, _ -> finish() }
                            .setNegativeButton("No") { _, _ -> }
                            .setNeutralButton("Volver al menú principal") { _, _ ->
                                // Abrir la actividad del menú principal
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            }
                            .show()
                    }
                }
            }
        val bundle :Bundle ?= intent.extras
        if (bundle!=null){
            val recibidos = bundle.getString("parametro").toString()
            val datosactividad01 = bundle.getString("datosactividad01").toString()
            txtseleccionados.setText(datosactividad01 + recibidos + "\n")
        }
    }
}