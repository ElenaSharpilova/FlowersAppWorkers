package android.example.flowerschemistryworkers.models

import java.io.Serializable


data class BouquetX(
    val cost: Int,
    val date: String,
    val dateExp: String,
    val description: String,
    val id: Int,
    val image: String,
    val name: String,
    val selection: String,
    val status: String
): Serializable