package android.example.flowerschemistryworkers.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.ActiveBouquetsAdapter
import android.example.flowerschemistryworkers.adapters.MyActiveOrdersAdapter
import android.example.flowerschemistryworkers.databinding.FragmentActiveBouquetsBinding
import android.example.flowerschemistryworkers.databinding.FragmentMyBouquetBinding
import android.example.flowerschemistryworkers.models.Bouquet
import android.example.flowerschemistryworkers.utils.OnItemClickLestenerMyBouquets
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

class ActiveBouquetsFragment : Fragment(), OnItemClickLestenerMyBouquets {
    private var _binding: FragmentActiveBouquetsBinding? = null
    private val binding get() = _binding!!
    private val adapterActiveBouquets by lazy { ActiveBouquetsAdapter(this@ActiveBouquetsFragment) }
    private val itemListActive by lazy {
        arrayListOf(
            Bouquet(1, "Язык любви", "розы, лилии, зелень", R.drawable.bouquet, 1000),
            Bouquet(2, "Нежность", "15 роз", R.drawable.bouquet, 540)
        )}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActiveBouquetsBinding.inflate(inflater, container, false)
        val view = binding.root
        setUpRecyclerViewMyBouquetActive()
        return view

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpRecyclerViewMyBouquetActive(){
        binding.rvMyActiveBouquets.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = adapterActiveBouquets
            adapterActiveBouquets.setList(itemListActive)
        }
    }

    override fun onItemClick(item: Bouquet) {
        findNavController().navigate(R.id.action_myBouquetFragment_to_descriptionBouquetFragment)
    }

}