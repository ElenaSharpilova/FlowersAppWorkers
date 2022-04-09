package android.example.flowerschemistryworkers.models

import java.io.Serializable


data class Courier(
    val id: Int,
    val image: String,
    val name: String,
    val password: String,
    val phoneNumber: String,
    val role: String,
    val salary: Int,
    val status: String,
    val surname: String,
    val workShift: String
): Serializable