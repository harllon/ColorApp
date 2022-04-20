package com.example.colorapp

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.colorapp.adapters.ColorRecyclerAdapter

class ColorItemDetailsLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<Long>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view = recyclerView.findChildViewUnder(e.x, e.y)
       /* if(view != null){
            return (recyclerView.getChildViewHolder(view) as ColorRecyclerAdapter.ViewHolder).getItemDetails()
        }*/
        return null
    }
}