package com.example.colorapp.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.colorapp.fragmentos.Data2Fragment
import com.example.colorapp.fragmentos.DataFragment
import com.example.colorapp.fragmentos.HsvFragment
import com.example.colorapp.fragmentos.SavedFragment

class DataSliderAdapter(activity: AppCompatActivity, val itemsCount: Int): FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment = when(position){
        0 -> DataFragment()
        1 -> Data2Fragment()
        2 -> HsvFragment()
        3 -> SavedFragment()
        else -> throw Exception("Invalid Fragment")
    }

    override fun getItemCount(): Int {
        return itemsCount
    }
}