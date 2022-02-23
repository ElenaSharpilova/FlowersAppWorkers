package android.example.flowerschemistryworkers.utils

import android.example.flowerschemistryworkers.models.Order
import androidx.recyclerview.widget.DiffUtil

class AllOrdersDiffUtil (
    private val oldList: List<Order>,
    private val newList: List<Order>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_ ,addressReceiver, sum) = oldList[oldItemPosition]
        val (_, new_addressReceiver, new_sum,) = newList[newItemPosition]
        return addressReceiver == new_addressReceiver && sum == new_sum
    }
}