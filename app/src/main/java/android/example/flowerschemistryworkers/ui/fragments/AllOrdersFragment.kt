package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.AllOrdersAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentAllOrdersBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.utils.OnItemClickListenerAllOrders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

class AllOrdersFragment : Fragment(), OnItemClickListenerAllOrders {
    private var _binding: FragmentAllOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterAllOrders by lazy { AllOrdersAdapter(this@AllOrdersFragment) }

    private val itemListAllOrders by lazy {
        arrayListOf(
            Order(1, "ул. Байтик Баатыра 233", "мкр.Аламедин-1, д.22, кв.134", "11:09", 1, 2399),
            Order(2, "ул. Байтик Баатыра 233", "ул. Пушкина 66", "22:07", 6, 1000),
            Order(3, "ул. Токтогул Сатылганова 176", "ул. Т. Молдо 78, д.22, кв.134", "07:45", 3, 4566),
            Order(4, "ул. Токтогул Сатылганова 176", "ул. Т. Молдо 78, д.22, кв.134", "07:45", 3, 4566)
        )}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewAllOrders()

        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun setUpRecyclerViewAllOrders(){
        binding.rvAllOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterAllOrders
            adapterAllOrders.setList(itemListAllOrders)
        }
    }

    override fun onItemClick(item: Order) {
        findNavController().navigate(R.id.action_allOrdersFragment_to_detailOrderFromAllOrdersFragment)
    }
}
