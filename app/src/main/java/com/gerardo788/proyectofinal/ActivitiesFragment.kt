package com.gerardo788.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.gerardo788.proyectofinal.databinding.FragmentActivitiesBinding
import com.gerardo788.proyectofinal.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActivitiesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActivitiesFragment : Fragment() {

    private var _binding: FragmentActivitiesBinding ?= null
    private val binding get() = _binding!!

    private val viewModel: DataViewModel by activityViewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)

        binding.buttonSubir.setOnClickListener {
            subirABase()
            Toast.makeText(activity,"Se apreto boton", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun subirABase() {

        viewModel.db.collection("Inmuebles").document(binding.editTextNumberId.text.toString()).set(
            hashMapOf("estado" to binding.editTextEstado.text.toString(),
                "alcaldiaOMunicipio" to binding.editTextAlcaldiaOMunicipio.text.toString(),
                "colonia" to binding.editTextColonia.text.toString(),
                "codigoPostal" to binding.editTextNumberCodigoPostal.text.toString(),
                "conjuntoOEdificio" to binding.editTextConjuntoOEdificio.text.toString(),
                "calle" to binding.editTextCalle.text.toString(),
                "numExterior" to binding.editTextNumberNumExterior.text.toString(),
                "numInterior" to binding.editTextNumberNumInterior.text.toString(),
                "tipoOperacion" to binding.editTextTipoOperacion.text.toString(),
                "tipoPropiedad" to binding.editTextTipoPropiedad.text.toString(),
                "precioEn" to binding.editTextPrecioEn.text.toString(),
                "cantidad" to binding.editTextCantidad.text.toString(),
                "amueblado" to binding.editTextAmueblado.text.toString(),
                "electrodomesticos" to binding.editTextElectrodomesticos.text.toString(),
                "factura" to binding.editTextFactura.text.toString(),
                "nombreAsesor" to binding.editTextNombreAsesor.text.toString(),
                "comision" to binding.editTextComision.text.toString(),
                "fechaProxContacto" to binding.editTextFechaProxContacto.text.toString(),
                "comentarios" to binding.editTextComentarios.text.toString())
        )

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ActivitiesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActivitiesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}