package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemAllOrdersBinding
import android.example.flowerschemistryworkers.models.Order
import android.example.flowerschemistryworkers.utils.AllOrdersDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class AllOrdersAdapter: RecyclerView.Adapter<AllOrdersAdapter.ViewHolder>() {
    private var list = mutableListOf<Order>()

    fun setList(newList: MutableList<Order>){
        val diffCallback = AllOrdersDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemAllOrdersBinding.bind(item)
        fun bind(item: Order) = with(binding){
            addressShop.text = item.addressShop
            addressReceiver.text = item.addressReceiver
            tvTime.text = item.time
            tvQuantity.text = item.quantity.toString()
            tvSum.text = item.sum.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_all_orders, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }
}