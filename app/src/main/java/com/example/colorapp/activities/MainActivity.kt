package com.example.colorapp.activities

import android.content.Intent
import com.example.colorapp.adapters.DataSliderAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.colorapp.databinding.ActivityMainBinding
import com.example.colorapp.fragments.dialogbox.HelpFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var main_binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
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
        signOut()
        help()
    }

    private fun signOut(){
        main_binding.signoutImageButton.setOnClickListener {
            auth = Firebase.auth
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun help(){
        main_binding.helpImageButton.setOnClickListener {
            showDialog()
        }
    }
    private fun showDialog(){
        val dialog = HelpFragment()
        dialog.show(supportFragmentManager, dialog.tag)
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

