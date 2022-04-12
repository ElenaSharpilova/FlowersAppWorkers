package android.example.flowerschemistryworkers.models

import java.io.Serializable


data class OrdersItem(
    val address: String,
    val bouquet: List<BouquetX>,
    val bouquetCost: Int,
    val buyerName: String,
    val buyerPhoneNumber: String,
    val client: Client,
    val date: String,
    val deliveryCost: Int,
    val existTime: String,
    val finalCost: Int,
    val id: Int,
    val orderType: String,
    val qOfBouquet: Int,
    val recieverName: String,
    val recieverPhoneNumber: String,
    val status: String
): Serializable