package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemMyOrdersActiveBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.utils.OnItemClickListenerMyOrders
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyActiveOrdersAdapter (val clickListener: OnItemClickListenerMyOrders):RecyclerView.Adapter<MyActiveOrdersAdapter.ViewHolder>() {

    private var listOrders = listOf<Order>()

    fun setList(newList: List<Order>){
        listOrders = newList
        notifyDataSetChanged()
    }

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemMyOrdersActiveBinding.bind(item)
        fun bind(item: Order, action: OnItemClickListenerMyOrders) = with(binding){
            addressShop.text = "Chui"
            addressReceiver.text = item.addressReceiver
            tvTime.text = item.time
            tvQuantity.text = item.name
            tvSum.text = item.sum.toString()
            itemView.setOnClickListener {
             action.onItemClickMyOrders(item)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_orders_active, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOrders[position], clickListener)
    }

    override fun getItemCount(): Int {
        return listOrders.size
    }
}