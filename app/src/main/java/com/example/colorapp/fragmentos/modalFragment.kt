package com.example.colorapp.fragmentos

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.colorapp.ColorApplication
import com.example.colorapp.ColorRoom.ColorEntity
import com.example.colorapp.R
import com.example.colorapp.viewModels.ColorRViewModel
import com.example.colorapp.viewModels.ColorRViewModelFactory
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.math.roundToLong


class modalFragment(private val color: Int) : DialogFragment() {
    private val colorRViewModel: ColorRViewModel by activityViewModels{
        ColorRViewModelFactory((activity?.application as ColorApplication).repository)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_template, container)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(1100, 1200)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHSVValues(color, view)
        setRGBValues(color, view)
        deleteColor(view, color)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setHSVValues(color: Int, view: View){
        val hTextView : TextView = view.findViewById(R.id.hTextView)
        val sTextView : TextView = view.findViewById(R.id.sTextView)
        val vTextView : TextView = view.findViewById(R.id.vTextView)

        val hsvArray =  FloatArray(3)
        Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), hsvArray)
        Log.d("valor do hsv", hsvArray[0].toString())
        Log.d("valor do red", Color.red(color).toString())
        val hString = "H value: " + round2(hsvArray[0]).toString()
        val sString = "S value: " + round2(hsvArray[1]).toString()
        val vString = "V value: " + round2(hsvArray[2]).toString()

        hTextView.setText(hString)
        sTextView.setText(sString)
        vTextView.setText(vString)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setRGBValues(color: Int, view: View){
        val rTextView : TextView = view.findViewById(R.id.rTextView)
        val gTextView : TextView = view.findViewById(R.id.gTextView)
        val bTextView : TextView = view.findViewById(R.id.bTextView)

        val rString = "R value: " + Color.red(color).toString()
        val gString = "G value: " + Color.green(color).toString()
        val bString = "B value: " + Color.blue(color).toString()


        rTextView.setText(rString)
        gTextView.setText(gString)
        bTextView.setText(bString)
    }

    fun round2(value: Float) : Double{
        return (value*100).roundToInt()/100.0
    }

    fun deleteColor(view: View, color: Int){
        val deleteButton: Button = view.findViewById(R.id.deleteSingleColor)
        deleteButton.setOnClickListener {
            val colorEnt = ColorEntity(color)
            colorRViewModel.deleteColor(colorEnt)
        }
    }
}