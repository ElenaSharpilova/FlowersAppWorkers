package android.example.flowerschemistryworkers.viewmodel

import android.example.flowerschemistryworkers.models.UserItem
import android.example.flowerschemistryworkers.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UsersViewModel (private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

    val userLiveData = MutableLiveData<ArrayList<UserItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

    }

    fun getUsers(){
        viewModelScope.launch {
            val response = repository.getAllUsers()
            if (response.isSuccessful){
                userLiveData.postValue(response.body())
            }
        }
    }
}