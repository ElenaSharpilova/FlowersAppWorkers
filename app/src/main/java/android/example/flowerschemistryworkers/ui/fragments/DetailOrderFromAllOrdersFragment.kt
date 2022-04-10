package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.adapters.DetailOrderAdapter
import android.example.flowerschemistryworkers.databinding.FragmentDetailOrderFromAllOrdersBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.models.OrderDetail
import android.util.Log
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager

class DetailOrderFromAllOrdersFragment : Fragment() {
    private var _binding: FragmentDetailOrderFromAllOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterDetailOrder by lazy{ DetailOrderAdapter() }
    private val args by navArgs<DetailOrderFromAllOrdersFragmentArgs>()
    val order = args.order.buyerName



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailOrderFromAllOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

            Log.i("myLog", order)
        //setUpRecyclerViewDetailOrders()

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
    }
}