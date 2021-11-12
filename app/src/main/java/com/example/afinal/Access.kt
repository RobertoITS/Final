package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class Access : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access)

        //Instanciamos la vista
        val spinner: Spinner = findViewById(R.id.spinner)

        //Creamos la lista de elemento
        //val list = listOf("Hola", "Adios", "Buen Día")

        //Mejor creamos una list array en el res/string
        val list = resources.getStringArray(R.array.list)

        //Creamos el adaptador con la lista
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)

        //Le agregamos el adaptador a la vista
        spinner.adapter = adaptador

        //Algunas funciones
        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@Access, list[p2], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }
}