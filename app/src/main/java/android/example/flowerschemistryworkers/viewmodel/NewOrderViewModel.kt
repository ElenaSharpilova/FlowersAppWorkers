package android.example.flowerschemistryworkers.viewmodel

import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class NewOrderViewModel(private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

    val newOrdersLiveData = MutableLiveData<ArrayList<OrdersItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getOrders()
    }

    fun getOrders() {
        viewModelScope.launch {
            val response = repository.getNewOrders()
            if (response.isSuccessful){
                newOrdersLiveData.postValue(response.body())
            }
        }
    }
}