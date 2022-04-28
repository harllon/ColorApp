package com.example.colorapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.colorapp.ColorItemDetailsLookup
import com.example.colorapp.R
import com.example.colorapp.colorRoom.ColorEntity

class ColorRecyclerAdapter(private val listColors: List<Int>?, private val onItemClicked: (Int) -> Unit) :
    RecyclerView.Adapter<ColorRecyclerAdapter.ViewHolder>(){
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val colorView: CardView = view.findViewById(R.id.circleColorViewRecycler)
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_color, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        listColors?.get(position)?.let { viewHolder.colorView.setCardBackgroundColor(it) }
            // tracker?.let { viewHolder.bind(listColors!!.get(position), it.isSelected(position.toLong())) }
        viewHolder.itemView.setOnClickListener{
            listColors?.let { it1 -> onItemClicked(it1.get(position)) }
        }

        /*listColors?.get(position)?.let { viewHolder.colorView.setBackgroundColor(it.color) }
       // tracker?.let { viewHolder.bind(listColors!!.get(position), it.isSelected(position.toLong())) }
        viewHolder.itemView.setOnClickListener{
            listColors?.let { it1 -> onItemClicked(it1.get(position).color) }
        }*/

        Log.d("Valor chegando no VH: ", listColors?.get(position).toString())
    }


    override fun getItemCount(): Int {
        return listColors?.size ?: 0
    }

    //override fun getItemId(position: Int): Long = position.toLong()

}