package com.example.colorapp.fragmentos

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.colorapp.R


class modalFragment(private val color: Color) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_template, container)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(1100, 1200 )
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHSVValues(color, view)
        setRGBValues(color, view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setHSVValues(color: Color, view: View){
        val hTextView : TextView = view.findViewById(R.id.hTextView)
        val sTextView : TextView = view.findViewById(R.id.sTextView)
        val vTextView : TextView = view.findViewById(R.id.vTextView)

        var hsvArray =  FloatArray(3)
        Color.RGBToHSV(color.red().toInt(), color.green().toInt(), color.blue().toInt(), hsvArray)

        val hString = "H value: " + hsvArray[0].toString()
        val sString = "S value: " + hsvArray[1].toString()
        val vString = "V value: " + hsvArray[2].toString()

        hTextView.setText(hString)
        sTextView.setText(sString)
        vTextView.setText(vString)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setRGBValues(color: Color, view: View){
        val rTextView : TextView = view.findViewById(R.id.rTextView)
        val gTextView : TextView = view.findViewById(R.id.gTextView)
        val bTextView : TextView = view.findViewById(R.id.bTextView)

        val rString = "R value: " + color.red().toString()
        val gString = "G value: " + color.green().toString()
        val bString = "B value: " + color.blue().toString()


        rTextView.setText(rString)
        gTextView.setText(gString)
        bTextView.setText(bString)
    }
}