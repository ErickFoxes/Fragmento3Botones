package com.echavez.fragmento3botones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.echavez.fragmento3botones.fragmentos.BotonesFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_botones.*

class MainActivity : AppCompatActivity(), BotonesFragment.OnLetterSelection {

    override fun setLetraA(letra_a: String) {
        //Snackbar.make(fg_botones,"Se a guardado con exito",Snackbar.LENGTH_SHORT).show()
        tv_vacio.setText("A")
    }

    override fun setLetraB(letra_b: String) {
        tv_vacio.setText("B")
    }

    override fun setLetraC(letra_c: String) {
        tv_vacio.setText("C")
    }

    override fun setMensaje(mensaje: String) {
        tv_vacio_mensaje.setText("Muchas gracias Nestor <3")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(fg_botones.id, BotonesFragment.newInstance("A", "B", "C"))
                .commit()

    }
}
