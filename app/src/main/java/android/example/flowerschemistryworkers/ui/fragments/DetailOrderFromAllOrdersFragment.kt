package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.adapters.DetailOrderAdapter
import android.example.flowerschemistryworkers.databinding.FragmentDetailOrderFromAllOrdersBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.models.OrderDetail
import androidx.recyclerview.widget.LinearLayoutManager

class DetailOrderFromAllOrdersFragment : Fragment() {
    private var _binding: FragmentDetailOrderFromAllOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterDetailOrder by lazy{ DetailOrderAdapter() }

    private val itemListDetailOrder by lazy {
        arrayListOf(
          OrderDetail(1,"Букет Гармония", 2, 3500),
          OrderDetail(2,"Ferrero rocher", 1, 500),
          OrderDetail(3,"Букет Слезы короля", 1, 5500)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailOrderFromAllOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewDetailOrders()

        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun  setUpRecyclerViewDetailOrders() {
        binding.rvDetailOrder.apply {
            adapter = adapterDetailOrder
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterDetailOrder.setList(itemListDetailOrder)
    }
}