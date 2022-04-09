package android.example.flowerschemistryworkers.repository

import android.example.flowerschemistryworkers.api.InterfaceAPI
import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.models.Token
import retrofit2.Response

class Repository constructor(private val serviceAPI: InterfaceAPI){

    suspend fun getAllOrders(): Response<ArrayList<OrdersItem>>{
        return serviceAPI.getAllOrders()
    }

    suspend fun getToken(number: String, uid: String): Response<Token> {
        return serviceAPI.getToken(number, uid)
    }

    suspend fun getActiveOrders(): Response<ArrayList<OrdersItem>>{
        return serviceAPI.getActiveOrders()
    }

    suspend fun getDoneOrders(): Response<ArrayList<OrdersItem>>{
        return serviceAPI.getDoneOrders()
    }

    suspend fun getNewOrders(): Response<ArrayList<OrdersItem>>{
        return serviceAPI.getNewOrders()
    }


}