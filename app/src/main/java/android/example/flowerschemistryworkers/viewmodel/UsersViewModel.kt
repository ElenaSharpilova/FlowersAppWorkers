package android.example.flowerschemistryworkers.viewmodel

import android.example.flowerschemistryworkers.models.Token
import android.example.flowerschemistryworkers.models.UserItem
import android.example.flowerschemistryworkers.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(private val repository: Repository) : ViewModel(), DefaultLifecycleObserver {

    var tokens = MutableLiveData<Token>()
    var errorMessage = MutableLiveData<String>()
//    val userLiveData = MutableLiveData<ArrayList<UserItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }

    fun getToken(number: String, uid: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val request = repository.getToken(number, uid)
            if (request.isSuccessful) {
                tokens.postValue(request.body())
            } else {
                errorMessage.postValue(request.errorBody().toString())
            }
        }
    }
}