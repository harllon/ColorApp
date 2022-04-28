package com.example.colorapp.fragments.dialogbox

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.colorapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class registerFragment : DialogFragment() {
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.round_corner)
        return inflater.inflate(R.layout.register_dialog, container)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.65).toInt()
        val heightChoosed = 1000
        dialog?.window?.setLayout(width, height)
        //dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,heightChoosed)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        register(view, auth)
    }

    private fun register(view : View, auth: FirebaseAuth){
        val registerButton: Button = view.findViewById(R.id.registerButton)
        val email: EditText = view.findViewById(R.id.emailEditText)
        val password: EditText = view.findViewById(R.id.passwordRegisterET)
        val confirmPassword: EditText = view.findViewById(R.id.confirmPasswordEditText)
        registerButton.setOnClickListener {
            if(email.text.isNullOrEmpty() || password.text.isNullOrEmpty() || confirmPassword.text.isNullOrEmpty()){
                Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }else{
                if(password.text.toString() != confirmPassword.text.toString()){
                    Toast.makeText(context, "Your password doesn't match with it confirmation", Toast.LENGTH_SHORT).show()
                }else{
                    activity?.let { it1 ->
                        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener(
                            it1
                        ){
                            if(it.isSuccessful){
                                Toast.makeText(context, "Successfully Signed Up", Toast.LENGTH_SHORT).show()
                                finish()
                            }else{
                                Toast.makeText(context, "Signed Up Failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun finish(){
        dialog?.dismiss()
    }
}