package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.ActiveBouquetsAdapter
import android.example.flowerschemistryworkers.adapters.SoldBouquetsAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentSoldBouquetsBinding
import android.example.flowerschemistryworkers.models.Bouquet
import androidx.recyclerview.widget.GridLayoutManager


class SoldBouquetsFragment : Fragment() {
    private var _binding: FragmentSoldBouquetsBinding? = null
    private val binding get() = _binding!!
    private val adapterSoldBouquets by lazy { SoldBouquetsAdapter() }
    private val itemListSold by lazy {
        arrayListOf(
            Bouquet(1, "Misty Bubbles", "букет комплимент с гортензией и зеленью", R.drawable.bouquet, 1000),
            Bouquet(2, "Лето в Амстердаме", "11 спрей роз Misty", R.drawable.bouquet, 540),
            Bouquet(3, "Индиго", "15 белоснежных лизиантусов в нетипичной темной упаковке", R.drawable.bouquet, 2000)
        )}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSoldBouquetsBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewMyBouquetSold()
        return view

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpRecyclerViewMyBouquetSold(){
        binding.rvMySoldBouquets.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = adapterSoldBouquets
            adapterSoldBouquets .setList(itemListSold)
        }
    }
}