package com.unallapps.ehliyetsinavinacalisiyorum.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseSubject
import com.unallapps.ehliyetsinavinacalisiyorum.data.Subject
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

    private val _lessonSelectedItem: MutableStateFlow<Int> = MutableStateFlow(0)
    val lessonSelectedItem: MutableStateFlow<Int> = _lessonSelectedItem

    private val _nameStateText: MutableStateFlow<String> = MutableStateFlow("Misafir Kullanıcı")
    val nameStateText: MutableStateFlow<String> = _nameStateText

    private val _alertDialog: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val alertDialog: MutableStateFlow<Boolean> = _alertDialog

    private val _selectedSubject: MutableStateFlow<Subject> =
        MutableStateFlow(DatabaseSubject.subjectLists[lessonSelectedItem.value])
    val selectedSubject: MutableStateFlow<Subject> = _selectedSubject

    fun getUserInfo() {
        viewModelScope.launch {
            userRepository.getUser()?.let {
                _userInfo.value = it
                _nameStateText.value = it.userName
            } ?: run {
                userRepository.insert(defaultUser)
                _userInfo.value = defaultUser
            }
        }
    }
}