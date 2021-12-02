package com.gerardo788.proyectofinal

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gerardo788.proyectofinal.databinding.ItemPropiedadBinding
import com.google.android.play.core.internal.t
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso

class AdapterRV (var propiedades: List<Propiedades>) : RecyclerView.Adapter<AdapterRV.ViewHolder>() {

    val storageRef = Firebase.storage
    val db = Firebase.firestore

    class ViewHolder (val binding: ItemPropiedadBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRV.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPropiedadBinding.inflate(layoutInflater,parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: AdapterRV.ViewHolder, position: Int) {

        //var storageRef1 = Firebase.storage.reference.child("images/"+propiedades[position].numID)

        holder.binding.apply {

            if (propiedades[position].disponible == "true"){
                buttonDisponible.setBackgroundColor(Color.GREEN)
            } else {
                buttonDisponible.setBackgroundColor(Color.RED)
            }
            Picasso.get().load(propiedades[position].urlFoto).into(imageViewFotoPropiedad)
            textViewAsesor.text = propiedades[position].nombreAsesor
            textViewDireccion.text = propiedades[position].calle + " " + propiedades[position].numExterior + ", " + propiedades[position].colonia
            textViewTipoPropiedad.text = propiedades[position].tipoPropiedad
            textViewTipoOperacion.text = propiedades[position].tipoOperacion
            textViewCantidad.text = "$"+propiedades[position].cantidad
            textViewNumRecamaras.text = propiedades[position].numeroRecamaras
            textViewNumBanos.text = propiedades[position].banosCompletos
            textViewNumEstacionamiento.text = propiedades[position].numeroEstacionamientos
            textViewM2Construccion.text = propiedades[position].metrosCuadradosConstruccion
            textViewM2Terreno.text = propiedades[position].metrosCuadradosTerreno

            buttonDisponible.setOnClickListener {
                val refPropiedad = db.collection("Inmuebles").document(propiedades[position].numID)
                if (propiedades[position].disponible == "true"){
                    refPropiedad.update("disponible", "false")
                    buttonDisponible.setBackgroundColor(Color.RED)
                } else {
                    refPropiedad.update("disponible", "true")
                    buttonDisponible.setBackgroundColor(Color.GREEN)
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return propiedades.size
    }


}