package com.example.colorapp

import com.example.colorapp.adapters.DataSliderAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.colorapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var main_binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main_binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main_binding.root)
        val pageAdapter = DataSliderAdapter(this, 4)
        main_binding.DataSlider.adapter = pageAdapter
        TabLayoutMediator(main_binding.Guia, main_binding.DataSlider){tab, position -> when(position){
            0 -> tab.text = "RGB Bar"
            1 -> tab.text = "RGB Hex"
            2 -> tab.text = "HSV"
            3 -> tab.text = "Saved Colors"
        }}.attach()
        //change()
    }

    /*fun change(){
        main_binding.changeButton.setOnClickListener {
            val colorHex = main_binding.colorEditTxt.text.toString()
            if(colorHex.isNotBlank()){
                try{
                    val color = ColorDrawable(Color.parseColor(colorHex))
                    main_binding.ColorView.background = color
                } catch(e: IllegalArgumentException){
                    Toast.makeText(this, "Cor invalida", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Escreva uma cor", Toast.LENGTH_LONG).show()
            }
            main_binding.colorEditTxt.setText("")
        }
    }*/
}

