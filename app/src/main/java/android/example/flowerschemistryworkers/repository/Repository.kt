package android.example.flowerschemistryworkers.repository

import android.example.flowerschemistryworkers.api.InterfaceAPI
import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.models.UserItem
import retrofit2.Response

class Repository constructor(private val serviceAPI: InterfaceAPI){

    suspend fun getAllOrders(): Response<ArrayList<OrdersItem>>{
        return serviceAPI.getAllOrders()
    }

    suspend fun getAllUsers(): Response<ArrayList<UserItem>>{
        return serviceAPI.getUsers()
    }


}