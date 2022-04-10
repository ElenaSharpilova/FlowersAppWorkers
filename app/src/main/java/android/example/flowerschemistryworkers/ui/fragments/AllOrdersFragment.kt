package android.example.flowerschemistryworkers.ui.fragments



import android.example.flowerschemistryworkers.adapters.AllOrdersAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentAllOrdersBinding
import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.utils.Delegates
import android.example.flowerschemistryworkers.viewmodel.NewOrderViewModel
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel

class AllOrdersFragment : Fragment(), Delegates.OrderClicked {
    private var _binding: FragmentAllOrdersBinding? = null
    private val binding get() = _binding!!

    private val ordersViewModel by viewModel<NewOrderViewModel>()
    private val  ordersAdapter by lazy{ AllOrdersAdapter(this) }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(ordersViewModel)
        setUpRecyclerViewAllOrders()
        ordersViewModel.newOrdersLiveData.observe(viewLifecycleOwner){
            ordersAdapter.setList(it.toList())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpRecyclerViewAllOrders(){
        binding.rvAllOrders.apply {
            adapter = ordersAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onItemClick(order: OrdersItem) {
        val action = AllOrdersFragmentDirections.actionAllOrdersFragmentToDetailOrderFromAllOrdersFragment(order)
        Log.i("myLog", order.buyerName)

        findNavController().navigate(action)
    }
}
