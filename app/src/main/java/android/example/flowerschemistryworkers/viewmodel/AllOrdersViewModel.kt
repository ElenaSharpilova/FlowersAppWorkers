package android.example.flowerschemistryworkers.viewmodel

import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class AllOrdersViewModel (private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

   val ordersLiveData = MutableLiveData<ArrayList<OrdersItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getOrders()
    }

    fun getOrders() {
        viewModelScope.launch {
            val response = repository.getAllOrders()
            if (response.isSuccessful){
                ordersLiveData.postValue(response.body())
            }
        }
    }
}