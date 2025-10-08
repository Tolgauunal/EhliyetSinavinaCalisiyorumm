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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val defaultUser = UserEntity(userName = Constants.String.DEFAULT_USER)

    private val _userInfo = MutableStateFlow(defaultUser)
    val userInfo: StateFlow<UserEntity> = _userInfo.asStateFlow()

    private val _userName = MutableStateFlow(defaultUser.userName)
    val userName: StateFlow<String?> = _userName.asStateFlow()

    private val _selectedLessonIndex = MutableStateFlow(0)
    val selectedLessonIndex: StateFlow<Int> = _selectedLessonIndex.asStateFlow()

    private val _selectedSubject = MutableStateFlow(DatabaseSubject.subjectLists.first())
    val selectedSubject: StateFlow<Subject> = _selectedSubject.asStateFlow()

    private val _isDialogVisible = MutableStateFlow(false)
    val isDialogVisible: StateFlow<Boolean> = _isDialogVisible.asStateFlow()

    init {
        viewModelScope.launch {
            val existingUser = userRepository.getUser()
            if (existingUser != null) {
                _userInfo.value = existingUser
                _userName.value = existingUser.userName
            } else {
                userRepository.insert(defaultUser)
                _userInfo.value = defaultUser
                _userName.value = defaultUser.userName
            }
        }
    }

    fun updateSelectedLesson(index: Int) {
        _selectedLessonIndex.value = index
    }

    fun updateSelectedSubject(subject: Subject) {
        val safeSubject = DatabaseSubject.subjectLists.getOrNull(subject.id)
        _selectedSubject.value = safeSubject ?: subject
    }

    fun showDialog(isVisible: Boolean) {
        _isDialogVisible.value = isVisible
    }
}