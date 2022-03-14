package android.example.flowerschemistryworkers.ui.fragments


import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.adapters.AllOrdersAdapter
import android.example.flowerschemistryworkers.api.RetrofitInstance
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistryworkers.databinding.FragmentAllOrdersBinding
import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.repository.Repository
import android.example.flowerschemistryworkers.utils.OnItemClickListenerAllOrders
import android.example.flowerschemistryworkers.viewmodel.AllOrdersViewModel
import android.example.flowerschemistryworkers.viewmodel.AllOrdersViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

class AllOrdersFragment : Fragment(), OnItemClickListenerAllOrders {
    private var _binding: FragmentAllOrdersBinding? = null
    private val binding get() = _binding!!
    private val retrofitService = RetrofitInstance.api
    lateinit var viewModel: AllOrdersViewModel
    lateinit var allOrdersAdapter: AllOrdersAdapter

    //private val adapterAllOrders by lazy { AllOrdersAdapter(this@AllOrdersFragment) }

    /*private val itemListAllOrders by lazy {
        arrayListOf(
            Order(1, "ул. Байтик Баатыра 233", "мкр.Аламедин-1, д.22, кв.134", "11:09", "Тимур", 2399),
            Order(2, "ул. Байтик Баатыра 233", "ул. Пушкина 66", "22:07", "Карина", 1000),
            Order(3, "ул. Токтогул Сатылганова 176", "ул. Т. Молдо 78, д.22, кв.134", "07:45", "Айгерим", 4566),
            Order(4, "ул. Токтогул Сатылганова 176", "ул. Т. Молдо 78, д.22, кв.134", "07:45", "Руслан", 4566)
        )}*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this, AllOrdersViewModelFactory(Repository(retrofitService)))
            .get(AllOrdersViewModel::class.java)

        setUpRecyclerViewAllOrders()

        viewModel.ordersResponse.observe(viewLifecycleOwner, {
            showProgressBar()
            allOrdersAdapter.setData(it)
            hideProgressBar()
        })
        viewModel.getOrders()

        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun setUpRecyclerViewAllOrders(){
        allOrdersAdapter = AllOrdersAdapter(this@AllOrdersFragment)
        binding.rvAllOrders.apply {
            adapter = allOrdersAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onItemClick(item: OrdersItem) {
        findNavController().navigate(R.id.action_allOrdersFragment_to_detailOrderFromAllOrdersFragment)
    }

}
