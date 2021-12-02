package com.gerardo788.proyectofinal

import android.app.Activity
import android.content.Intent

object ImageController {
    fun selectPhotoFromGallery(fragment: ActivitiesFragment, code: Int){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        fragment.startActivityForResult(intent, code)
    }
}