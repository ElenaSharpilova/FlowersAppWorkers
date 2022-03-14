package android.example.flowerschemistryworkers.repository

import android.example.flowerschemistryworkers.api.InterfaceAPI

class Repository constructor(private val serviceAPI: InterfaceAPI){

    fun getAllOrders() = serviceAPI.getAllOrders()
}