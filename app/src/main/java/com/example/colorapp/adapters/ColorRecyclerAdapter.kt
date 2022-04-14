package com.example.colorapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colorapp.R

class ColorRecyclerAdapter(private val listColors: List<Int>?) :
    RecyclerView.Adapter<ColorRecyclerAdapter.ViewHolder>(){
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val colorView: View = view.findViewById(R.id.colorView)
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_color, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        listColors?.get(position)?.let { viewHolder.colorView.setBackgroundColor(it) }
        Log.d("Valor chegando no VH: ", listColors?.get(position).toString())
    }

    override fun getItemCount(): Int {
        return listColors!!.size
    }

}