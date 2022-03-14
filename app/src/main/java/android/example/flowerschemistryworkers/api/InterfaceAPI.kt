package android.example.flowerschemistryworkers.api

import android.example.flowerschemistryworkers.models.OrdersItem
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceAPI {

    @GET("order")
    fun getAllOrders(): Call<List<OrdersItem>>
}