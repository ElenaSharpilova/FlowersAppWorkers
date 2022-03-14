package android.example.flowerschemistryworkers.models

data class Order(
    val id: Int,
    var addressShop: String,
    var addressReceiver: String,
    var time: String,
    var name: String,
    var sum: Int
)
