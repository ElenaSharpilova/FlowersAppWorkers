package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemAllOrdersBinding
import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.utils.OnItemClickListenerAllOrders
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AllOrdersAdapter(val clickListener: OnItemClickListenerAllOrders)
    : RecyclerView.Adapter<AllOrdersAdapter.ViewHolder>() {

    var listOrders= mutableListOf<OrdersItem>()

    fun setData(newList: List<OrdersItem>){
        listOrders = newList.toMutableList()
        notifyDataSetChanged()
    }

    /*var list = ArrayList <Order>()
    fun setList(newList: MutableList<Order>){
        val diffCallback = AllOrdersDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }*/

    class ViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemAllOrdersBinding.bind(item)
        fun bind(item: OrdersItem, action:OnItemClickListenerAllOrders) = with(binding){
            addressShop.text = item.filial
            addressReceiver.text = item.address
            //tvTime.text = item.date
            tvNameReciever.text = item.recieverName
            //tvSum.text = item.sum.toString()

            itemView.setOnClickListener{
                action.onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_all_orders, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOrders[position], clickListener)
    }

    override fun getItemCount(): Int {
       return listOrders.size
    }
}