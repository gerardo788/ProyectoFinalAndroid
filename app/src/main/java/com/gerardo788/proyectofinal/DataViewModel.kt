package com.gerardo788.proyectofinal

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

class DataViewModel : ViewModel() {

    val db = Firebase.firestore
    val storageRef = Firebase.storage
    val _propiedades = mutableListOf<Propiedades>()

    fun obtenerPropiedades (){
        db.collection("Inmuebles").get().addOnSuccessListener { result ->
            _propiedades.clear()
            for (document in result){
                _propiedades.add(Propiedades(
                    colonia = document.get("colonia") as String,
                    calle = document.get("calle") as String,
                    numExterior = document.get("numExterior") as String,
                    tipoOperacion = document.get("tipoOperacion") as String,
                    tipoPropiedad = document.get("tipoPropiedad") as String,
                    cantidad = document.get("cantidad") as String,
                    nombreAsesor = document.get("nombreAsesor") as String,
                    numeroRecamaras = document.get("numeroRecamaras") as String,
                    banosCompletos = document.get("banosCompletos") as String,
                    numeroEstacionamientos = document.get("numeroEstacionamientos") as String,
                    metrosCuadradosConstruccion = document.get("metrosCuadradosConstruccion") as String,
                    metrosCuadradosTerreno = document.get("metrosCuadradosTerreno") as String,
                    numID = document.get("id") as String))
            }
        }
    }


}