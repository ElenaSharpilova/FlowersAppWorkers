package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemMyOrdersActiveBinding
import android.example.flowerschemistryworkers.databinding.ItemMyOrdersCompletedBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.utils.MyOrdersDiffUtil
import android.example.flowerschemistryworkers.utils.OnItemClickListenerMyOrders
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyCompletedOrdersAdapter
    : RecyclerView.Adapter<MyCompletedOrdersAdapter.ViewHolder>() {

    var list = ArrayList <Order>()
    fun setList(newList: MutableList<Order>){
        val diffCallback = MyOrdersDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemMyOrdersCompletedBinding.bind(item)
        fun bind(item: Order) = with(binding){
            addressShop.text = item.addressShop
            addressReceiver.text = item.addressReceiver
            tvTime.text = item.time
            tvQuantity.text = item.name.toString()
            tvSum.text = item.sum.toString()

            /*itemView.setOnClickListener{
                action.onItemClick(item)
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_orders_completed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}