package android.example.flowerschemistryworkers.api

import android.example.flowerschemistryworkers.models.OrdersItem
import android.example.flowerschemistryworkers.models.Token
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface InterfaceAPI {

    @GET("order")
    suspend fun getAllOrders(): Response<ArrayList<OrdersItem>>

    @FormUrlEncoded
    @POST("auth/login/user")
    suspend fun getToken(
        @Field("phoneNumber") phoneNumber: String,
        @Field("password") password: String
    ): Response<Token>

    @GET("order/activeOrder")
    suspend fun getActiveOrders(): Response<ArrayList<OrdersItem>>

    @GET("order/doneStatus")
    suspend fun getDoneOrders(): Response<ArrayList<OrdersItem>>

    @GET("order/aaa")
    suspend fun getNewOrders(): Response<ArrayList<OrdersItem>>
}
