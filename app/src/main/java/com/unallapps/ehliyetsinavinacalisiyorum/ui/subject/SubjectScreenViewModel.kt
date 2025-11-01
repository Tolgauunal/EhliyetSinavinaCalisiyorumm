package com.unallapps.ehliyetsinavinacalisiyorum.ui.subject

import androidx.lifecycle.ViewModel
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseSubject
import com.unallapps.ehliyetsinavinacalisiyorum.data.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SubjectScreenViewModel @Inject constructor() : ViewModel() {

    private val _selectedLessonIndex = MutableStateFlow(0)
    val selectedLessonIndex: StateFlow<Int> = _selectedLessonIndex

    private val _selectedSubject = MutableStateFlow(DatabaseSubject.subjectLists[_selectedLessonIndex.value])
    val selectedSubject: StateFlow<Subject> = _selectedSubject

    private val _isAlertDialogVisible = MutableStateFlow(false)
    val isAlertDialogVisible: StateFlow<Boolean> = _isAlertDialogVisible

    fun selectLesson(index: Int) {
        _selectedLessonIndex.value = index
        _selectedSubject.value = DatabaseSubject.subjectLists.getOrElse(index) { _selectedSubject.value }
    }

    fun setAlertDialogVisible(isVisible: Boolean) {
        _isAlertDialogVisible.value = isVisible
    }
}