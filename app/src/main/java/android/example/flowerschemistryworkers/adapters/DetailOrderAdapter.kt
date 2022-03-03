package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemDetailOrderBinding
import android.example.flowerschemistryworkers.models.OrderDetail
import android.example.flowerschemistryworkers.utils.DetailDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class DetailOrderAdapter: RecyclerView.Adapter<DetailOrderAdapter.MyViewHolder>() {

    private var list = mutableListOf<OrderDetail>()

    fun setList(newList: MutableList<OrderDetail>){
        val diffCallback = DetailDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class MyViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemDetailOrderBinding.bind(item)
        fun bind(item: OrderDetail) = with(binding){
            tvName.text = item.name
            tvQuantity.text = item.quantity.toString()
            tvSum.text = item.sum.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_order, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}