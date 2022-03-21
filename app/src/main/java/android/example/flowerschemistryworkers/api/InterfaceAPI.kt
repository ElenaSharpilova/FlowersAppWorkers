package android.example.flowerschemistryworkers.api

import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.models.UserItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceAPI {

    @GET("order")
    suspend fun getAllOrders(): Response<ArrayList<OrdersItem>>

    @GET("users")
    suspend fun getUsers(): Response<ArrayList<UserItem>>
}