package android.example.flowerschemistryworkers.models

data class Order(
    val id: Int,
    var addressShop: String,
    var addressReceiver: String,
    var time: String,
    var quantity: Int,
    var sum: Int
)
