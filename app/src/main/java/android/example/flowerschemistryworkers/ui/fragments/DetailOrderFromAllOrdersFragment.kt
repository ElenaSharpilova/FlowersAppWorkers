package android.example.flowerschemistryworkers.ui.fragments

import android.example.flowerschemistryworkers.adapters.DetailOrderAdapter
import android.example.flowerschemistryworkers.databinding.FragmentDetailOrderFromAllOrdersBinding
import android.example.flowerschemistryworkers.models.BouquetX
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
    lateinit var order: List<BouquetX>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailOrderFromAllOrdersBinding.inflate(inflater, container, false)
        val view = binding.root
        order = args.order.bouquet
        setUpRecyclerViewDetailOrders()
        binding.addressReceiver.text = args.order.address
        binding.nameReceiver.text = args.order.recieverName
        binding.phoneReceiver.text = args.order.recieverPhoneNumber
        binding.nameSender.text = args.order.buyerName
        binding.phoneNumberSender.text = args.order.buyerPhoneNumber
      binding.tvTotalSum.text = args.order.finalCost.toString()

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
        adapterDetailOrder.setList(order)
    }
}