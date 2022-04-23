package com.example.colorapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.colorapp.ColorApplication
import com.example.colorapp.colorRoom.ColorEntity
import com.example.colorapp.databinding.FragmentData2Binding
import com.example.colorapp.viewModels.ColorRViewModel
import com.example.colorapp.viewModels.ColorRViewModelFactory
import com.example.colorapp.viewModels.ColorViewModel
import com.example.colorapp.viewModels.ProgressoViewModel
import java.lang.IllegalArgumentException

class Data2Fragment : Fragment() {
    private var _binding : FragmentData2Binding? = null
    private val data2Binding get() = _binding!!
    private val colorModel : ColorViewModel by activityViewModels()
    private val model : ProgressoViewModel by activityViewModels()
    private val colorRViewModel: ColorRViewModel by activityViewModels{
        ColorRViewModelFactory((activity?.application as ColorApplication).repository)
    }
    private var colorString: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentData2Binding.inflate(inflater, container, false)
        return data2Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        save()
        colorRViewModel.allColors.observe(viewLifecycleOwner){
            for(value in it){
                Log.d("valores salvo: ", value.toString())
            }
        }
    }

    private fun setup(){
        data2Binding.ChangeColorButton.setOnClickListener {
            if(data2Binding.HexEditTxt.text.isNotBlank()){
                colorString = "#" + data2Binding.HexEditTxt.text.toString()
                try {
                    colorModel.setColor(Color.parseColor(colorString))
                    Log.d("valor esperado: ", Color.parseColor(colorString).toString())
                }catch (e: IllegalArgumentException){
                    Toast.makeText(context, "Please, write a valid color", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(context, "Please, write a color", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun save(){
        data2Binding.saveButton.setOnClickListener {
            var colString = ColorEntity(Color.parseColor(colorString))
            colorRViewModel.insert(colString)
            /*for (colors in colorRViewModel.allColors.value!!){
                Log.d("cor", colors.toString())
            }*/
        }
    }

}