package android.example.flowerschemistryworkers.viewmodel

import android.example.flowerschemistryworkers.repository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AllOrdersViewModelFactory (private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllOrdersViewModel(repository) as T
    }

}