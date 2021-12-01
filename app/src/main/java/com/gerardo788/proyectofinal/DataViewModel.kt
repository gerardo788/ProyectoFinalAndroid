package com.gerardo788.proyectofinal

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DataViewModel : ViewModel() {

    public val db = Firebase.firestore

    //var lista con propiedades
    // nombre de usuario


}