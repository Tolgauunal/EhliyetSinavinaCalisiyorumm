package com.unallapps.ehliyetsinavinacalisiyorum.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseSubject
import com.unallapps.ehliyetsinavinacalisiyorum.data.Subject
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val defaultUser = UserEntity(userName = Constants.String.DEFAULT_USER)

    private val _userInfo: MutableStateFlow<UserEntity> = MutableStateFlow(defaultUser)
    val userInfo: StateFlow<UserEntity> = _userInfo

    private val _lessonSelectedItem: MutableStateFlow<Int> = MutableStateFlow(0)
    val lessonSelectedItem: MutableStateFlow<Int> = _lessonSelectedItem

    private val _userName: MutableStateFlow<String?> = MutableStateFlow(null)
    val userName: MutableStateFlow<String?> = _userName

    private val _alertDialog: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val alertDialog: MutableStateFlow<Boolean> = _alertDialog

    private val _selectedSubject: MutableStateFlow<Subject> =
        MutableStateFlow(DatabaseSubject.subjectLists[lessonSelectedItem.value])
    val selectedSubject: MutableStateFlow<Subject> = _selectedSubject

    init {
        viewModelScope.launch {
            userRepository.getUser()?.let {
                _userInfo.value = it
                _userName.value = it.userName
            } ?: run {
                userRepository.insert(defaultUser)
                _userInfo.value = defaultUser
                _userName.value = defaultUser.userName
            }
        }
    }

    fun setLessonSelectedItem(data: Int) {
        _lessonSelectedItem.value = data
    }

    fun setSelectedSubject(data: Subject) {
        _selectedSubject.value = DatabaseSubject.subjectLists[data.id]
    }

    fun setAlertDialog(data: Boolean) {
        _alertDialog.value = data
    }
}