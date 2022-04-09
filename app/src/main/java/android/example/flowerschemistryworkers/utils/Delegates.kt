package android.example.flowerschemistryworkers.utils

import android.example.flowerschemistryworkers.models.OrdersItem

interface Delegates {
    interface OrderClicked {
        fun onItemClick(order: OrdersItem)
    }
}
