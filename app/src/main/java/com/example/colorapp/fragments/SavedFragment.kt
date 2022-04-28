package com.example.colorapp.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.colorapp.ColorApplication
import com.example.colorapp.adapters.ColorRecyclerAdapter
import com.example.colorapp.databinding.FragmentSavedBinding
import com.example.colorapp.fragments.dialogbox.modalFragment
import com.example.colorapp.viewModels.ColorRViewModel
import com.example.colorapp.viewModels.ColorRViewModelFactory

class SavedFragment : Fragment() {
    private var _binding: FragmentSavedBinding? = null
    private val savedBinding get() = _binding!!
    private val colorRViewModel: ColorRViewModel by activityViewModels{
        ColorRViewModelFactory((activity?.application as ColorApplication).repository)
    }
    //private var tracker: SelectionTracker<Long>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        return savedBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listColors = colorRViewModel.getAllColors()
        if(listColors?.isEmpty() == true){
            savedBinding.textView10.visibility = View.INVISIBLE
        }else{
            savedBinding.textView10.visibility = View.VISIBLE
        }
        var adapter = ColorRecyclerAdapter(listColors){ valor -> showDialog(valor)}
        //tracker = SelectionTracker.Builder<Long>("mySelection", savedBinding.colorRecycler, StableIdKeyProvider(savedBinding.colorRecycler), ColorItemDetailsLookup(savedBinding.colorRecycler), StorageStrategy.createLongStorage()).withSelectionPredicate(SelectionPredicates.createSelectAnything()).build()
        savedBinding.colorRecycler.layoutManager = GridLayoutManager(context,3)
       // adapter.tracker = tracker
        savedBinding.colorRecycler.adapter = adapter
        colorRViewModel.allColors.observe(viewLifecycleOwner){
            if(it.isEmpty()){
                savedBinding.textView10.visibility = View.INVISIBLE
            }else{
                savedBinding.textView10.visibility = View.VISIBLE
            }
            adapter = ColorRecyclerAdapter(it){valor -> showDialog(valor)}
            savedBinding.colorRecycler.adapter = adapter
        }

        delete()


    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun showDialog(value: Int){
        //val color: Color = Color.valueOf(value)
        val dialog = modalFragment(value)
        dialog.show(parentFragmentManager, dialog.tag)
        //Toast.makeText(context, "opa, cor é: " + value, Toast.LENGTH_SHORT).show()

    }
    private fun delete(){
        savedBinding.deleteButton.setOnClickListener {
            colorRViewModel.deleteAll()
        }
    }
}