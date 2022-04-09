package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.adapters.MyActiveOrdersAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentActiveOrdersBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.viewmodel.ActiveOrdersViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel

class ActiveOrdersFragment : Fragment() {
    private var _binding: FragmentActiveOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterActiveOrders by lazy { MyActiveOrdersAdapter() }
    private val activeOrdersViewModel by viewModel<ActiveOrdersViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActiveOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(activeOrdersViewModel)
        setUpRecyclerViewMyOrdersActive()
        activeOrdersViewModel.activeOrdersLiveData.observe(viewLifecycleOwner){
            adapterActiveOrders.setList(it.toList())
        }
    }

    private fun setUpRecyclerViewMyOrdersActive() {
        binding.rvMyActiveOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterActiveOrders
        }
    }
}