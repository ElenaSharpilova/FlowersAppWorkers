package android.example.flowerschemistryworkers.models

import java.io.Serializable

data class Client(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val role: String
): Serializable