package com.example.colorapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.colorapp.ColorApplication
import com.example.colorapp.colorRoom.ColorEntity
import com.example.colorapp.databinding.FragmentDataBinding
import com.example.colorapp.viewModels.ColorRViewModel
import com.example.colorapp.viewModels.ColorRViewModelFactory
import com.example.colorapp.viewModels.ProgressoViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class DataFragment : Fragment() {
    private var _binding : FragmentDataBinding? = null
    private val dataBinding get()  = _binding!!
    private val model: ProgressoViewModel by activityViewModels()
    private val colorRViewModel: ColorRViewModel by activityViewModels{
        ColorRViewModelFactory((activity?.application as ColorApplication).repository)
    }
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val observerR = Observer<Int>{
            if(model.getR() != null){
                if(model.getAccessMode()){
                    dataBinding.RvalueEdittxt.setText(model.getR().toString())
                }else{
                    dataBinding.Rbar.progress = model.getR()!!
                }
            }
        }
        model.progressoR.observe(viewLifecycleOwner, observerR)

        val observerG = Observer<Int>{
            if(model.getG() != null){
                if(model.getAccessMode()){
                    dataBinding.GvalueEdittxt.setText(model.getG().toString())
                }else{
                    dataBinding.Gbar.progress = model.getG()!!
                }
            }

        }
        model.progressoG.observe(viewLifecycleOwner, observerG)

        val observerB = Observer<Int>{
            if(model.getB() != null){
                if(model.getAccessMode()){
                    dataBinding.BvalueEdittxt.setText(model.getB().toString())
                }else{
                    dataBinding.Bbar.progress = model.getB()!!
                }
            }
        }
        model.progressoB.observe(viewLifecycleOwner, observerB)

        setup()
        save()

    }


    private fun setup(){

        //RED COLOR

        dataBinding.RvalueEdittxt.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(dataBinding.RvalueEdittxt.text.isNotBlank() && dataBinding.RvalueEdittxt.text.toString().toInt() <= dataBinding.Rbar.max){
                    model.setR(dataBinding.RvalueEdittxt.text.toString().toInt())
                }
            }
        })
        dataBinding.Rbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    model.setR(dataBinding.Rbar.progress, fromUser)
                }else{
                    if(model.fromHexRed){
                        model.setR(dataBinding.Rbar.progress, true)
                        model.fromHexRed = false
                    }
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //GREEN COLOR

        dataBinding.GvalueEdittxt.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(dataBinding.GvalueEdittxt.text.isNotBlank() && dataBinding.GvalueEdittxt.text.toString().toInt() <= dataBinding.Gbar.max){
                    model.setG(dataBinding.GvalueEdittxt.text.toString().toInt())
                }
            }
        })
        dataBinding.Gbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    model.setG(dataBinding.Gbar.progress, fromUser)
                }else{
                    if(model.fromHexGreen){
                        model.setG(dataBinding.Gbar.progress, true)
                        model.fromHexGreen = false
                    }
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //BLUE COLOR

        dataBinding.BvalueEdittxt.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(dataBinding.BvalueEdittxt.text.isNotBlank() && dataBinding.BvalueEdittxt.text.toString().toInt() <= dataBinding.Bbar.max){
                    model.setB(dataBinding.BvalueEdittxt.text.toString().toInt())
                }
            }
        })
        dataBinding.Bbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    model.setB(dataBinding.Bbar.progress, fromUser)
                }else{
                    if(model.fromHexBlue){
                        model.setB(dataBinding.Bbar.progress, true)
                        model.fromHexBlue = false
                    }
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


    }
    private fun save(){
        dataBinding.saveButtonRGB.setOnClickListener {
            val red = model.getR() ?: 0
            val green = model.getG() ?: 0
            val blue = model.getB() ?: 0
            val colorInt = Color.rgb(red, green, blue)
            val colString = ColorEntity(colorInt)
            try {
                colorRViewModel.insert(colString)
                Toast.makeText(context, "Color Successfully Saved!", Toast.LENGTH_SHORT).show()
            }catch (exception: Exception){
                Toast.makeText(context, "Unable to save the color", Toast.LENGTH_SHORT).show()
            }


        }
    }
}