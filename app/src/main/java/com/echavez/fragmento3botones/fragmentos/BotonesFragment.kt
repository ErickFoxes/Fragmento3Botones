package com.echavez.fragmento3botones.fragmentos

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.echavez.fragmento3botones.R
import kotlinx.android.synthetic.main.fragment_botones.view.*

private const val ARG_LETRA_A  = "letra_a"
private const val ARG_LETRA_B  = "letra_b"
private const val ARG_LETRA_C  = "letra_c"
private const val ARG_MENSAJE = "mensaje"

class BotonesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var letra_a: String? = null
    private var letra_b: String? = null
    private var letra_c: String? = null
    private var mensaje: String? = null
    private var listener: OnLetterSelection? = null

    interface OnLetterSelection {
        fun setLetraA(letra_a: String)
        fun setLetraB(letra_b: String)
        fun setLetraC(letra_c: String)
        fun setMensaje(mensaje: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLetterSelection) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnLetterSelection")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letra_a = it.getString(ARG_LETRA_A)
            letra_b = it.getString(ARG_LETRA_B)
            letra_c = it.getString(ARG_LETRA_C)
            mensaje = it.getString(ARG_MENSAJE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_botones, container, false).apply {
            btn_letraA.setOnClickListener {
                listener?.setLetraA("A")
            }

            btn_letraB.setOnClickListener {
                listener?.setLetraB("B")
            }

            btn_letraC.setOnClickListener {
                listener?.setLetraC("C")
            }
            btn_mensaje.setOnClickListener {
                listener?.setMensaje("hey")
            }
        }
    }



    override fun onDetach() {
        super.onDetach()
        listener = null
    }



    companion object {
        @JvmStatic
        fun newInstance(letra_a: String, letra_b: String, letra_c: String) =
            BotonesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LETRA_A, letra_a)
                    putString(ARG_LETRA_B, letra_b)
                    putString(ARG_LETRA_C, letra_c)
                    putString(ARG_MENSAJE, mensaje)
                }
            }
    }
}
