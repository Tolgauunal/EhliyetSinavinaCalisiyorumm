package com.unallapps.ehliyetsinavinacalisiyorum.ui.home

import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val defaultUser = UserEntity( userName = "Misafir Kullanıcı")
    private val _userInfo: MutableStateFlow<UserEntity> = MutableStateFlow(defaultUser)
    val userInfo: StateFlow<UserEntity> = _userInfo


    fun getUserInfo() {
        viewModelScope.launch {
            userRepository.getUser()?.let {
                _userInfo.value = it
            }?:run {
                userRepository.insert(defaultUser)
                _userInfo.value=defaultUser
            }
        }
    }
}