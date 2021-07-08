package fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.colorapp.R
import com.example.colorapp.databinding.FragmentHsvBinding
import viewModels.ProgressoViewModel

class HsvFragment : Fragment() {
    private var _binding : FragmentHsvBinding? = null
    private val hsvBinding get() = _binding!!
    private val model : ProgressoViewModel by activityViewModels()
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
    }

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


}