package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemMyOrdersActiveBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.utils.MyOrdersDiffUtil
import android.example.flowerschemistryworkers.utils.OnItemClickListenerMyOrders
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyActiveOrdersAdapter
    :RecyclerView.Adapter<MyActiveOrdersAdapter.ViewHolder>() {

    private var listOrders = listOf<OrdersItem>()

    fun setList(newList: List<OrdersItem>){
        listOrders = newList
        notifyDataSetChanged()
    }

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemMyOrdersActiveBinding.bind(item)
        fun bind(item: OrdersItem) = with(binding){
            addressShop.text = "Chui"
            addressReceiver.text = item.address
            tvTime.text = item.existTime
            tvQuantity.text = item.recieverName
            tvSum.text = item.finalCost.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_orders_active, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOrders[position])
    }

    override fun getItemCount(): Int {
        return listOrders.size
    }
}