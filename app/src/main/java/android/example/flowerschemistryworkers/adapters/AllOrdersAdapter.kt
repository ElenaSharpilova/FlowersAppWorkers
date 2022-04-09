package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemAllOrdersBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.utils.Delegates
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AllOrdersAdapter(private val orderClicked: Delegates.OrderClicked) : RecyclerView.Adapter<AllOrdersAdapter.ViewHolder>() {

   private var listOrders = listOf<OrdersItem>()

    fun setList(newList: List<OrdersItem>){
        listOrders = newList
        notifyDataSetChanged()
    }

    class ViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemAllOrdersBinding.bind(item)
        fun bind(item: OrdersItem) = with(binding){
            addressShop.text = "Киевская"
            addressReceiver.text = item.address
            tvTime.text = item.existTime
            tvSum.text = item.finalCost.toString()
            tvNameReciever.text = item.recieverName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_all_orders, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOrders[position])
        holder.binding.cvBouquet.setOnClickListener {
            orderClicked.onItemClick(listOrders[position])
        }
    }

    override fun getItemCount(): Int {
       return listOrders.size
    }
}