package com.example.colorapp.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.colorapp.ColorApplication
import com.example.colorapp.colorRoom.ColorEntity
import com.example.colorapp.databinding.FragmentHsvBinding
import com.example.colorapp.viewModels.ColorRViewModel
import com.example.colorapp.viewModels.ColorRViewModelFactory
import com.example.colorapp.viewModels.ProgressoViewModel

class HsvFragment : Fragment() {
    private var _binding : FragmentHsvBinding? = null
    private val hsvBinding get() = _binding!!
    private val model : ProgressoViewModel by activityViewModels()
    private val colorRViewModel: ColorRViewModel by activityViewModels{
        ColorRViewModelFactory((activity?.application as ColorApplication).repository)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHsvBinding.inflate(inflater, container, false)
        model.initialize()
        return hsvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val observerH = Observer<Float>{
            if(model.getH() != null){
                hsvBinding.Htextview.text = model.getH().toString()
                //Log.d("Valores:", model.hsv.value?.get(0).toString())
            }
        }
        model.progressoH.observe(viewLifecycleOwner, observerH)

        val observerS = Observer<Float>{
            if(model.getS() != null){
                hsvBinding.Stextview.text = model.getS().toString()
            }
        }
        model.progressoS.observe(viewLifecycleOwner, observerS)

        val observerV = Observer<Float>{
            if(model.getV() != null){
                hsvBinding.Vtextview.text = model.getV().toString()
            }
        }
        model.progressoV.observe(viewLifecycleOwner, observerV)

        setup()
        save()
        //observeRGB()
    }

    /*private fun observeRGB(){
        var rValue = model.getR()
        var gValue = model.getG()
        var bValue = model.getB()
        val observerB = Observer<Int> {
            bValue = model.getB()
            syncroRGB(rValue, gValue, bValue)
        }
        model.progressoB.observe(viewLifecycleOwner, observerB)
        val observerR = Observer<Int> {
            if(model.getR() != null){
                rValue = model.getR()
                syncroRGB(rValue, gValue, bValue)
            }
        }
        model.progressoR.observe(viewLifecycleOwner, observerR)
        val observerG = Observer<Int> {
            if(model.getG() != null){
                gValue = model.getG()
                syncroRGB(rValue, gValue, bValue)
            }
        }
        model.progressoG.observe(viewLifecycleOwner, observerG)
    }

    private fun syncroRGB(rValue: Int, gValue: Int, bValue: Int){
        val hsvArray = FloatArray(3)
        Color.colorToHSV(Color.rgb(rValue, gValue, bValue), hsvArray)
        model.setH(hsvArray[0])
        model.setS(hsvArray[1])
        model.setV(hsvArray[2])
        //setup()
    }*/

    private fun setup(){
        hsvBinding.Hbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                model.setH(hsvBinding.Hbar.progress.toFloat()/100)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        hsvBinding.Sbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                model.setS(hsvBinding.Sbar.progress.toFloat()/100)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        hsvBinding.Vbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                model.setV(hsvBinding.Vbar.progress.toFloat()/100)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun save(){
        hsvBinding.saveButtonHSV.setOnClickListener {
            val h = model.getH() ?: 0F
            val s = model.getS() ?: 0F
            val v = model.getV() ?: 0F
            val hsv = floatArrayOf(h, s, v)
            val colorInt = Color.HSVToColor(hsv)
            val colString = ColorEntity(colorInt)
            colorRViewModel.insert(colString)
        }
    }

}