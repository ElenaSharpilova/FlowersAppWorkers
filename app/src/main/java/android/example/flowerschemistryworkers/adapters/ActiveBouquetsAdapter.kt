package android.example.flowerschemistryworkers.adapters

import android.example.flowerschemistryworkers.R
import android.example.flowerschemistryworkers.databinding.ItemCardBouquetBinding
import android.example.flowerschemistryworkers.models.Bouquet
import android.example.flowerschemistryworkers.utils.MyBouquetDiffUtil
import android.example.flowerschemistryworkers.utils.OnItemClickLestenerMyBouquets
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ActiveBouquetsAdapter(val clickListener: OnItemClickLestenerMyBouquets) : RecyclerView.Adapter<ActiveBouquetsAdapter.ViewHolder>() {

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
        fun bind(item: Bouquet, action:OnItemClickLestenerMyBouquets) = with(binding){
            tvBouquetName.text = item.name
            tvBouquetDescription.text = item.description
            tvPrice.text = item.price.toString()
            ivBouquet.setImageResource(item.img)
            itemView.setOnClickListener{
                action.onItemClick(item)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveBouquetsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_bouquet, parent, false)
        return ActiveBouquetsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActiveBouquetsAdapter.ViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}