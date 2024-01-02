package com.unallapps.ehliyetsinavinacalisiyorum.ui.profil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun insert(name:String){
        CoroutineScope(Dispatchers.IO).launch {
            val newUser=UserEntity(userName = name)
            userRepository.insert(newUser)
        }
    }
}