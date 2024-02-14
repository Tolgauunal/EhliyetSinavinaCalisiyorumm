package com.unallapps.ehliyetsinavinacalisiyorum.ui.home

import android.graphics.BitmapFactory
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseKonular
import com.unallapps.ehliyetsinavinacalisiyorum.data.Konular
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val defaultUser = UserEntity(userName = "Misafir Kullanıcı")
    private val _userInfo: MutableStateFlow<UserEntity> = MutableStateFlow(defaultUser)
    val userInfo: StateFlow<UserEntity> = _userInfo

    private val _derslerSelectedItem: MutableStateFlow<Int> = MutableStateFlow(0)
    val derslerSelectedItem : MutableStateFlow<Int> = _derslerSelectedItem

    private val _nameStateText: MutableStateFlow<String> = MutableStateFlow("Misafir Kullanıcı")
    val nameStateText : MutableStateFlow<String> = _nameStateText

    private val _alertDialog: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val alertDialog : MutableStateFlow<Boolean> = _alertDialog

    private val _selectedKonu: MutableStateFlow<Konular> = MutableStateFlow(DatabaseKonular.konularList[derslerSelectedItem.value])
    val selectedKonu : MutableStateFlow<Konular> = _selectedKonu

    fun getUserInfo() {
        viewModelScope.launch {
            userRepository.getUser()?.let {
                _userInfo.value = it
                _nameStateText.value =it.userName
            } ?: run {
                userRepository.insert(defaultUser)
                _userInfo.value = defaultUser
            }
        }
    }
}