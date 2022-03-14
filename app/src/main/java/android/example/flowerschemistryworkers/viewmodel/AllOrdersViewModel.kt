package android.example.flowerschemistryworkers.viewmodel

import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.repository.Repository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllOrdersViewModel (private val repository: Repository): ViewModel() {

    val ordersResponse = MutableLiveData<List<OrdersItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getOrders(){
        val response = repository.getAllOrders()
        response.enqueue(object : Callback<List<OrdersItem>> {
            override fun onResponse(call: Call<List<OrdersItem>>, response: Response<List<OrdersItem>>) {
                ordersResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<List<OrdersItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}