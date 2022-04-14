package com.example.colorapp.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colorapp.ColorApplication
import com.example.colorapp.R
import com.example.colorapp.adapters.ColorRecyclerAdapter
import com.example.colorapp.databinding.FragmentSavedBinding
import com.example.colorapp.viewModels.ColorRViewModel
import com.example.colorapp.viewModels.ColorRViewModelFactory

class SavedFragment : Fragment() {
    private var _binding: FragmentSavedBinding? = null
    private val savedBinding get() = _binding!!
    private val colorRViewModel: ColorRViewModel by activityViewModels{
        ColorRViewModelFactory((activity?.application as ColorApplication).repository)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        return savedBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listColors = colorRViewModel.getAllColors()
        var adapter = ColorRecyclerAdapter(listColors)
        savedBinding.colorRecycler.layoutManager = GridLayoutManager(context,3)
        savedBinding.colorRecycler.adapter = adapter
        colorRViewModel.allColors.observe(viewLifecycleOwner){
            adapter = ColorRecyclerAdapter(it)
            savedBinding.colorRecycler.adapter = adapter
        }
        delete()


    }

    private fun delete(){
        savedBinding.deleteButton.setOnClickListener {
            colorRViewModel.deleteAll()
        }
    }
}