package adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import fragmentos.Data2Fragment
import fragmentos.DataFragment
import fragmentos.HsvFragment

class DataSliderAdapter(activity: AppCompatActivity, val itemsCount: Int): FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment = when(position){
        0 -> DataFragment()
        1 -> Data2Fragment()
        2 -> HsvFragment()
        else -> throw Exception("Invalid Fragment")
    }

    override fun getItemCount(): Int {
        return itemsCount
    }
}