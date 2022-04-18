package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.MyActiveOrdersAdapter
import android.example.flowerschemistryworkers.databinding.FragmentActiveOrdersBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.utils.OnItemClickListenerMyOrders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

class ActiveOrdersFragment : Fragment(), OnItemClickListenerMyOrders {
    private var _binding: FragmentActiveOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterActiveOrders by lazy { MyActiveOrdersAdapter(this@ActiveOrdersFragment) }
    private val itemListActive by lazy {
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
        _binding = FragmentActiveOrdersBinding.inflate(inflater, container, false)
        val view = binding.root
        setUpRecyclerViewMyOrdersActive()

        return view
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(activeOrdersViewModel)
        setUpRecyclerViewMyOrdersActive()
        activeOrdersViewModel.activeOrdersLiveData.observe(viewLifecycleOwner){
            adapterActiveOrders.setList(it.toList())
        }
    }*/

    private fun setUpRecyclerViewMyOrdersActive() {
        binding.rvMyActiveOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterActiveOrders
            adapterActiveOrders.setList(itemListActive)
        }

    }

    override fun onItemClickMyOrders(item: Order) {
        findNavController().navigate(R.id.action_myOrderFragment_to_detailOrderFromMyOrdersFragment)
    }


}