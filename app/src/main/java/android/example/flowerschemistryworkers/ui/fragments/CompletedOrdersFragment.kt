package android.example.flowerschemistryworkers.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.MyActiveOrdersAdapter
import android.example.flowerschemistryworkers.adapters.MyCompletedOrdersAdapter
import android.example.flowerschemistryworkers.databinding.FragmentActiveOrdersBinding
import android.example.flowerschemistryworkers.databinding.FragmentCompletedOrdersBinding
import android.example.flowerschemistryworkers.models.Order
import androidx.recyclerview.widget.LinearLayoutManager

class CompletedOrdersFragment : Fragment() {
    private var _binding: FragmentCompletedOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterCompletedOrders by lazy { MyCompletedOrdersAdapter() }
    private val itemListCompleted by lazy {
        arrayListOf(
            Order(1, "ул. Ахунбаева 90", "мкр.Аламедин-1, д.22, кв.134", "11:09", "Кубан", 2399),
            Order(2, "ул. Ж.Пудовкина 30", "ул. Пушкина 66", "22:07", "Айгерим", 1000),
            Order(
                3,
                "ул. Токтогул Сатылганова 176",
                "ул. Т. Молдо 78, д.22, кв.134",
                "07:45",
                "Бегим",
                4566
            ),
            Order(
                4,
                "ул.  12 мкр, д.3, кв. 6",
                "ул. Т. Молдо 78, д.22, кв.134",
                "07:45",
                "Элина",
                4566
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompletedOrdersBinding.inflate(inflater, container, false)
        val view = binding.root
        setUpRecyclerViewMyOrdersCompleted()
        return view
    }

    private fun setUpRecyclerViewMyOrdersCompleted() {
        binding.rvMyCompletedOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterCompletedOrders
            adapterCompletedOrders.setList(itemListCompleted)
        }
    }
}