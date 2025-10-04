package com.unallapps.ehliyetsinavinacalisiyorum.ui.profile

import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    private val _userInfo: MutableStateFlow<UserEntity?> = MutableStateFlow(null)
    val userInfo: StateFlow<UserEntity?> = _userInfo

    private var byteArray: ByteArray? = null

    private val _nameStateText: MutableStateFlow<String> =
        MutableStateFlow(R.string.default_User.toString())
    val nameStateText: MutableStateFlow<String> = _nameStateText

    private val _userImage: MutableStateFlow<ByteArray?> = MutableStateFlow(null)
    val userImage: MutableStateFlow<ByteArray?> = _userImage

    private val _changeNameControl: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val changeNameControl: StateFlow<Boolean> = _changeNameControl

    @DrawableRes
    private val _settingsIcon = MutableStateFlow(R.drawable.baseline_settings_24)
    val settingsIcon = _settingsIcon

    init {
        viewModelScope.launch {
            _userInfo.value = userRepository.getUser()
            _nameStateText.value =
                userRepository.getUser()?.userName ?: Constants.String.DEFAULT_USER
            _userImage.value = userInfo.value?.userPhoto
        }
    }

    fun setSettingsIcon() {
        _settingsIcon.value =
            if (_changeNameControl.value) {
                R.drawable.baseline_settings_24
            } else {
                R.drawable.baseline_edit_24
            }
    }

    fun insertOrUpdate(name: String) {
        viewModelScope.launch {
            if (userRepository.getUserSize().isNotEmpty()) {
                userRepository.updateUserName(name, 1)
                _userInfo.value = userRepository.getUser()
            } else {
                userRepository.insert(UserEntity(userName = name))
                _userInfo.value = userRepository.getUser()
            }
        }
        _nameStateText.value = name
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

    fun setChangeNameControl(boolean: Boolean) {
        _changeNameControl.value = boolean
    }

    fun setName(data: String) {
        _nameStateText.value = data
    }
}