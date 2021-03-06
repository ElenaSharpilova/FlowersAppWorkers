package android.example.flowerschemistryworkers.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.DetailOrderAdapter
import android.example.flowerschemistryworkers.databinding.FragmentDetailOrderFromMyOrdersBinding
import android.example.flowerschemistryworkers.databinding.FragmentMyOrdersBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.models.OrderDetail
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

class DetailOrderFromMyOrdersFragment : Fragment() {
    private var _binding: FragmentDetailOrderFromMyOrdersBinding? = null
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
        _binding = FragmentDetailOrderFromMyOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        //setUpRecyclerViewDetailOrders()

        binding.btnReceivedOrder.setOnClickListener {
            binding.btnReceivedOrder.visibility = View.GONE
            binding.btnAcceptedOrder.visibility = View.VISIBLE
        }

        binding.btnAcceptedOrder.setOnClickListener {
            binding.btnAcceptedOrder.visibility = View.GONE
            binding.btnOnWay.visibility = View.VISIBLE
        }

        binding.btnOnWay.setOnClickListener {
            binding.btnOnWay.visibility = View.GONE
            binding.btnArrived.visibility = View.VISIBLE
        }

        binding.btnArrived.setOnClickListener {
            binding.btnArrived.visibility = View.GONE
            binding.btnCompleted.visibility = View.VISIBLE
        }


        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /*private fun  setUpRecyclerViewDetailOrders() {
        binding.rvDetailOrder.apply {
            adapter = adapterDetailOrder
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterDetailOrder.setList(itemListDetailOrder)
    }*/

}