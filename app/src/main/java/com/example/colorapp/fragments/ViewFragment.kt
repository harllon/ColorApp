package com.example.colorapp.fragments

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.colorapp.viewModels.ProgressoViewModel
import com.example.colorapp.databinding.FragmentViewBinding
import com.example.colorapp.viewModels.ColorViewModel

class ViewFragment : Fragment() {
    private var _binding: FragmentViewBinding? = null
    private val viewBinding get() = _binding!!
    private val model: ProgressoViewModel by activityViewModels()
    private val colorModel: ColorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentViewBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var redColor: Int = 0
        var greenColor: Int = 0
        var blueColor: Int = 0
        val observerR = Observer<Int>{
            redColor -> model.getR()
            if(model.getG() == null){
                model.setG(0)
            }
            if(model.getB() == null){
                model.setB(0)
            }
            changeColor(redColor, model.getG(), model.getB())
        }
        model.progressoR.observe(viewLifecycleOwner, observerR)

        val observerG = Observer<Int>{
            greenColor -> model.getG();
            if(model.getR() == null){
                model.setR(0)
            }
            if(model.getB() == null){
                model.setB(0)
            }
            changeColor(model.getR(), greenColor, model.getB())
        }
        model.progressoG.observe(viewLifecycleOwner, observerG)

        val observerB = Observer<Int>{
            blueColor -> model.getB()
            if(model.getR() == null){
                model.setR(0)
            }
            if(model.getG() == null){
                model.setG(0)
            }
            changeColor(model.getR(), model.getG(), blueColor)
        }
        model.progressoB.observe(viewLifecycleOwner, observerB)
        changeColor(redColor, greenColor, blueColor)

        val observerColor = Observer<Int>{
            //changeColorHex(colorModel.getColor()!!)
            model.fromHexRed = true
            model.fromHexBlue = true
            model.fromHexGreen = true
            model.setB(Color.blue(colorModel.getColor()!!))
            model.setR(Color.red(colorModel.getColor()!!))
            model.setG(Color.green(colorModel.getColor()!!))
            changeColor(model.getR(), model.getG(), model.getB())
        }
        colorModel.color.observe(viewLifecycleOwner, observerColor)

        val observerHSV = Observer<FloatArray>{
            model.fromHexRed = true
            model.fromHexBlue = true
            model.fromHexGreen = true
            model.setB(Color.blue(Color.HSVToColor(model.hsv.value)))
            model.setR(Color.red(Color.HSVToColor(model.hsv.value)))
            model.setG(Color.green(Color.HSVToColor(model.hsv.value)))
            changeColor(model.getR(), model.getG(), model.getB())
        }
        model.hsv.observe(viewLifecycleOwner, observerHSV)
    }

    /*private fun changeColorHex(color: Int){
        viewBinding.ColorView.setBackgroundColor(color)
    }*/

    @RequiresApi(Build.VERSION_CODES.O)
    private fun changeColor(redColor:Int?, greenColor:Int?, blueColor:Int?){
        if(redColor != null && greenColor != null && blueColor != null){
            //Log.d("observador", "entrei aqui oh")
            viewBinding.ColorView.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor))
        }
    }
}