package com.unallapps.ehliyetsinavinacalisiyorum.ui.profil

import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val defaultUser = UserEntity(1, "Misafir Kullanıcı")
    private val _userInfo: MutableStateFlow<UserEntity> = MutableStateFlow(defaultUser)
    val userInfo: StateFlow<UserEntity> = _userInfo
    private var byteArray: ByteArray? = null
    private val _nameStateText: MutableStateFlow<String> = MutableStateFlow("Misafir Kullanıcı")
    val nameStateText : MutableStateFlow<String> = _nameStateText
    private val _userImage: MutableStateFlow<ByteArray?> = MutableStateFlow(null)
    val userImage : MutableStateFlow<ByteArray?> = _userImage

    val _isDeleteAll: MutableStateFlow<Boolean> = MutableStateFlow(true)

    @DrawableRes
    private val _settingsIcon = MutableStateFlow(R.drawable.baseline_settings_24)
     val settingsIcon = _settingsIcon
     fun setSettingsIcon() {
        _settingsIcon.value =
            if (_isDeleteAll.value) R.drawable.baseline_settings_24 else R.drawable.baseline_edit_24
    }
    init {
        viewModelScope.launch {
            if (userRepository.getUserSize().size == 0) {
                userRepository.insert(defaultUser)
            }
        }
    }

    fun getUserName() {
        viewModelScope.launch {
            userRepository.getUser()?.let {
                _userInfo.value = it
                _nameStateText.value =it.userName
                _userImage.value=it.userPhoto
            } ?: run {
                userRepository.insert(defaultUser)
                _userInfo.value = defaultUser
            }
        }
    }

    fun insertOrUpdate(name: String) {
        viewModelScope.launch {
            if (userRepository.getUserSize().size > 0) {
                userRepository.updateUserName(name, 1)
                _userInfo.value = userRepository.getUser()
            } else {
                val newUser = UserEntity(userName = name)
                userRepository.insert(newUser)
                _userInfo.value = userRepository.getUser()
            }
        }
    }

    fun savePhoto(photoBitmap: Bitmap) {
        viewModelScope.launch {
            photoBitmap.let {
                val outputStream = ByteArrayOutputStream()
                photoBitmap.compress(Bitmap.CompressFormat.JPEG, 10, outputStream)
                byteArray = outputStream.toByteArray()
                userRepository.updateImage(byteArray, 1)
                _userInfo.value = userRepository.getUser()
            }.runCatching {}
        }
    }
}