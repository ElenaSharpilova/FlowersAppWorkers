package android.example.flowerschemistryworkers.ui.fragments



import android.example.flowerschemistryworkers.adapters.AllOrdersAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentAllOrdersBinding
import android.example.flowerschemistryworkers.viewmodel.AllOrdersViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel

class AllOrdersFragment : Fragment() {
    private var _binding: FragmentAllOrdersBinding? = null
    private val binding get() = _binding!!
    private val ordersViewModel by viewModel<AllOrdersViewModel>()
    private val ordersAdapter by lazy { AllOrdersAdapter() }



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
        ordersViewModel.ordersLiveData.observe(viewLifecycleOwner){
            ordersAdapter.setData(it.toList())
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


}
