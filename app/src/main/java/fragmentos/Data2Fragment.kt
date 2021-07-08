package fragmentos

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.colorapp.R
import com.example.colorapp.databinding.FragmentData2Binding
import viewModels.ColorViewModel
import viewModels.ProgressoViewModel
import java.lang.IllegalArgumentException

class Data2Fragment : Fragment() {
    private var _binding : FragmentData2Binding? = null
    private val data2Binding get() = _binding!!
    private val colorModel : ColorViewModel by activityViewModels()
    private val model : ProgressoViewModel by activityViewModels()

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
    }

    private fun setup(){
        data2Binding.ChangeColorButton.setOnClickListener {
            if(data2Binding.HexEditTxt.text.isNotBlank()){
                val colorString = "#" + data2Binding.HexEditTxt.text.toString()
                try {
                    colorModel.setColor(Color.parseColor(colorString))
                }catch (e: IllegalArgumentException){
                    Toast.makeText(context, "Please, write a valid color", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(context, "Please, write a color", Toast.LENGTH_LONG).show()
            }
        }
    }

}