package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.ui.fragments.ActiveBouquetsFragment
import android.example.flowerschemistryworkers.ui.fragments.ActiveOrdersFragment
import android.example.flowerschemistryworkers.ui.fragments.CompletedOrdersFragment
import android.example.flowerschemistryworkers.ui.fragments.SoldBouquetsFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BouquetsPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ActiveBouquetsFragment()
            1 -> return SoldBouquetsFragment()
        }
        return SoldBouquetsFragment()
    }

    companion object{
        const val NUM_TABS =2
    }
}