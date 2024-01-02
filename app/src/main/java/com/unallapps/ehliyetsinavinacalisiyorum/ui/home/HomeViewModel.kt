package com.unallapps.ehliyetsinavinacalisiyorum.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    val defaultUser = UserEntity(1, "Misafir Kullanıcı")
    private val _userInfo: MutableStateFlow<UserEntity> = MutableStateFlow(defaultUser)
    val userInfo: StateFlow<UserEntity> = _userInfo
    init {
        viewModelScope.launch {
            userRepository.getUserName()?.let {
                _userInfo.value=it
            }
        }
    }

    fun getUserIno() {
        viewModelScope.launch {
            userRepository.getUserName()?.let {
                _userInfo.value=it
            }
        }
    }
}