package android.example.flowerschemistryworkers.ui.fragments


import android.example.flowerschemistryworkers.adapters.BouquetsPagerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentMyBouquetBinding
import com.google.android.material.tabs.TabLayoutMediator


class MyBouquetFragment : Fragment() {
    private var _binding: FragmentMyBouquetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyBouquetBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.myBouquetsViewpager
        val tabLayout = binding.myBouquetsTablayout

        val adapter = BouquetsPagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        val categoryArray = arrayOf(
            "Активные",
            "Проданные"
        )
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = categoryArray[position]
        }.attach()

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

