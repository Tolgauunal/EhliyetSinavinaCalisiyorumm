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
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user: MutableStateFlow<UserEntity?> = MutableStateFlow(null)
    val user: StateFlow<UserEntity?> = _user

    private val _userName: MutableStateFlow<String> =
        MutableStateFlow(Constants.String.DEFAULT_USER)
    val userName: StateFlow<String> = _userName

    private val _userPhoto: MutableStateFlow<ByteArray?> = MutableStateFlow(null)
    val userPhoto: StateFlow<ByteArray?> = _userPhoto

    private val _isEditingName: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isEditingName: StateFlow<Boolean> = _isEditingName

    @DrawableRes
    private val _settingsIcon: MutableStateFlow<Int> =
        MutableStateFlow(R.drawable.baseline_settings_24)
    val settingsIcon: StateFlow<Int> = _settingsIcon

    private var photoByteArray: ByteArray? = null

    init {
        viewModelScope.launch {
            val currentUser = userRepository.getUser()
            _user.value = currentUser
            _userName.value = currentUser?.userName ?: Constants.String.DEFAULT_USER
            _userPhoto.value = currentUser?.userPhoto
        }
    }

    fun toggleSettingsIcon() {
        _settingsIcon.value = if (_isEditingName.value) {
            R.drawable.baseline_settings_24
        } else {
            R.drawable.baseline_edit_24
        }
    }

    fun saveUserName(name: String) {
        viewModelScope.launch {
            if (userRepository.getUserSize().isNotEmpty()) {
                userRepository.updateUserName(name, 1)
            } else {
                userRepository.insert(UserEntity(userName = name))
            }
            _user.value = userRepository.getUser()
            _userName.value = name
        }
    }

    fun saveUserPhoto(photoBitmap: Bitmap) {
        viewModelScope.launch {
            val outputStream = ByteArrayOutputStream()
            photoBitmap.compress(Bitmap.CompressFormat.JPEG, 10, outputStream)
            photoByteArray = outputStream.toByteArray()
            userRepository.updateImage(photoByteArray, 1)
            _user.value = userRepository.getUser()
            _userPhoto.value = photoByteArray
        }
    }

    fun setEditingName(isEditing: Boolean) {
        _isEditingName.value = isEditing
        toggleSettingsIcon()
    }

    fun updateUserNameLocally(name: String) {
        _userName.value = name
    }
}