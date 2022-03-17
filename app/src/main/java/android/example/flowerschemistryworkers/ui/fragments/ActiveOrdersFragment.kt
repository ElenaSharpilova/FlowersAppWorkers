package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.adapters.MyActiveOrdersAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentActiveOrdersBinding
import android.example.flowerschemistryworkers.models.Order
import androidx.recyclerview.widget.LinearLayoutManager

class ActiveOrdersFragment : Fragment() {
    private var _binding: FragmentActiveOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterActiveOrders by lazy { MyActiveOrdersAdapter() }
    private val itemListActive by lazy {
        arrayListOf(
            Order(1, "ул. Фучика 285", "мкр.Аламедин-1, д.22, кв.134", "11:09", "Айгерим", 2399),
            Order(2, "ул. Байтик Баатыра 233", "ул. Пушкина 66", "22:07", "Айбек", 1000)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActiveOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewMyOrdersActive()
        return view


    }


    private fun setUpRecyclerViewMyOrdersActive() {
        binding.rvMyActiveOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterActiveOrders
            adapterActiveOrders.setList(itemListActive)
        }
    }
}