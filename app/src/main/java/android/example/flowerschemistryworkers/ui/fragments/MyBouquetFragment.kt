package android.example.flowerschemistryworkers.ui.fragments

import android.content.res.ColorStateList
import android.example.flowerschemistryworkers.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.adapters.MyBouquetAdapter
import android.example.flowerschemistryworkers.databinding.FragmentMyBouquetBinding
import android.example.flowerschemistryworkers.models.Bouquet
import android.example.flowerschemistryworkers.utils.OnItemClickLestenerMyBouquets
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager


class MyBouquetFragment : Fragment(), OnItemClickLestenerMyBouquets {
    private var _binding: FragmentMyBouquetBinding? = null
    private val binding get() = _binding!!
    private val adapterMyBouquets by lazy { MyBouquetAdapter(this@MyBouquetFragment) }

    private val itemListActive by lazy {
        arrayListOf(
            Bouquet(1, "Язык любви", "розы, лилии, зелень", R.drawable.bouquet, 1000),
            Bouquet(2, "Нежность", "15 роз", R.drawable.bouquet, 540)
        )}

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
        _binding = FragmentMyBouquetBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewMyBouquetActive()

        binding.btnSold.setOnClickListener {
            setUpRecyclerViewMyBouquetSold()
        }

        binding.btnActive.setOnClickListener {
            setUpRecyclerViewMyBouquetActive()
        }

        return view

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(item: Bouquet) {
        findNavController().navigate(R.id.action_myBouquetFragment_to_descriptionBouquetFragment)
    }

    private fun setUpRecyclerViewMyBouquetActive(){
        binding.rvMyBouquet.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = adapterMyBouquets
            adapterMyBouquets.setList(itemListActive)
        }
    }

    private fun setUpRecyclerViewMyBouquetSold(){
        binding.rvMyBouquet.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = adapterMyBouquets
            adapterMyBouquets.setList(itemListSold)
        }
    }
}

