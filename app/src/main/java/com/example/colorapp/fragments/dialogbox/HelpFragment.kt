package com.example.colorapp.fragments.dialogbox

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.colorapp.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HelpFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.round_corner)
        return inflater.inflate(R.layout.help_dialog, container)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.65).toInt()
        //val heightChoosed = 1000
        dialog?.window?.setLayout(width, height)
        //dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,heightChoosed)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val helpButton : Button = view.findViewById(R.id.helpButton)
        helpButton.setOnClickListener {
            finish()
        }
    }

    private fun finish(){
        dialog?.dismiss()
    }
}