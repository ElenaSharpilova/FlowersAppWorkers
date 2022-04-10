package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemDetailOrderBinding
import android.example.flowerschemistryworkers.models.BouquetX
import android.example.flowerschemistryworkers.models.OrderDetail
import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.utils.DetailDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class DetailOrderAdapter: RecyclerView.Adapter<DetailOrderAdapter.MyViewHolder>() {

    private var list = listOf<BouquetX>()

    fun setList(newList: List<BouquetX>){
        list = newList
        notifyDataSetChanged()
    }

    class MyViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemDetailOrderBinding.bind(item)
        fun bind(item: BouquetX) = with(binding){
            tvName.text = item.name
          //  tvQuantity.text = item..toString()
            tvSum.text = item.cost.toString()
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