package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.AllOrdersAdapter
import android.example.flowerschemistryworkers.adapters.MyOrdersAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentMyOrdersBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.utils.OnItemClickListenerAllOrders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

class MyOrdersFragment : Fragment(), OnItemClickListenerAllOrders {
    private var _binding: FragmentMyOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterMyOrders by lazy { MyOrdersAdapter(this@MyOrdersFragment) }

    private val itemListActive by lazy {
        arrayListOf(
            Order(1, "ул. Фучика 285", "мкр.Аламедин-1, д.22, кв.134", "11:09", 1, 2399),
            Order(2, "ул. Байтик Баатыра 233", "ул. Пушкина 66", "22:07", 6, 1000)
        )}

    private val itemListCompleted by lazy {
        arrayListOf(
            Order(1, "ул. Ахунбаева 90", "мкр.Аламедин-1, д.22, кв.134", "11:09", 1, 2399),
            Order(2, "ул. Ж.Пудовкина 30", "ул. Пушкина 66", "22:07", 6, 1000),
            Order(3, "ул. Токтогул Сатылганова 176", "ул. Т. Молдо 78, д.22, кв.134", "07:45", 3, 4566),
            Order(4, "ул.  12 мкр, д.3, кв. 6", "ул. Т. Молдо 78, д.22, кв.134", "07:45", 3, 4566)
        )}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewMyOrdersActive()

        binding.btnCompletedOrder.setOnClickListener {
            setUpRecyclerViewMyOrdersCompleted()
        }

        binding.btnActiveOrder.setOnClickListener {
            setUpRecyclerViewMyOrdersActive()
        }

        return view

    }

    private fun setUpRecyclerViewMyOrdersActive(){
        binding.rvMyOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterMyOrders
            adapterMyOrders.setList(itemListActive)
        }
    }

    private fun setUpRecyclerViewMyOrdersCompleted(){
        binding.rvMyOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterMyOrders
            adapterMyOrders.setList(itemListCompleted)
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(item: Order) {
        findNavController().navigate(R.id.action_myOrderFragment_to_detailOrderFromMyOrdersFragment)
    }

}