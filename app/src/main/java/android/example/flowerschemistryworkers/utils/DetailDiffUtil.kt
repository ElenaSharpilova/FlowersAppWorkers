package android.example.flowerschemistryworkers.utils


import android.example.flowerschemistryworkers.models.OrderDetail
import androidx.recyclerview.widget.DiffUtil

class DetailDiffUtil (
    private val oldList: List<OrderDetail>,
    private val newList: List<OrderDetail>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_ ,name, sum) = oldList[oldItemPosition]
        val (_, new_name, new_sum,) = newList[newItemPosition]
        return name == new_name && sum == new_sum
    }
}