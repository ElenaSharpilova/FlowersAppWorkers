package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemCardBouquetBinding
import android.example.flowerschemistryworkers.models.Bouquet
import android.example.flowerschemistryworkers.utils.MyBouquetDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class SoldBouquetsAdapter : RecyclerView.Adapter<SoldBouquetsAdapter.ViewHolder>() {

    var list = ArrayList <Bouquet>()
    fun setList(newList: MutableList<Bouquet>){
        val diffCallback = MyBouquetDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemCardBouquetBinding.bind(item)
        fun bind(item: Bouquet) = with(binding){
            tvBouquetName.text = item.name
            tvBouquetDescription.text = item.description
            tvPrice.text = item.price.toString()
            ivBouquet.setImageResource(item.img)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoldBouquetsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_bouquet_sold, parent, false)
        return SoldBouquetsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SoldBouquetsAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}