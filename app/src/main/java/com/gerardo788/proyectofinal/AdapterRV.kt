package com.gerardo788.proyectofinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gerardo788.proyectofinal.databinding.ItemPropiedadBinding
import com.google.android.play.core.internal.t
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class AdapterRV (var propiedades: List<Propiedades>) : RecyclerView.Adapter<AdapterRV.ViewHolder>() {

    val storageRef = Firebase.storage

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

            textViewAsesor.text = propiedades[position].nombreAsesor
            textViewDireccion.text = propiedades[position].calle + " " + propiedades[position].numExterior + ", " + propiedades[position].colonia
            textViewTipoPropiedad.text = propiedades[position].tipoPropiedad
            textViewTipoOperacion.text = propiedades[position].tipoOperacion
            textViewCantidad.text = propiedades[position].cantidad.toString()
            textViewNumRecamaras.text = propiedades[position].numeroRecamaras.toString()
            textViewNumBanos.text = propiedades[position].banosCompletos.toString()
            textViewNumEstacionamiento.text = propiedades[position].numeroEstacionamientos.toString()
            textViewM2Construccion.text = propiedades[position].metrosCuadradosConstruccion.toString()
            textViewM2Terreno.text = propiedades[position].metrosCuadradosTerreno.toString()

        }

    }

    override fun getItemCount(): Int {
        return propiedades.size
    }


}