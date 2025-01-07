package com.unallapps.ehliyetsinavinacalisiyorum.ui.subject

import androidx.lifecycle.ViewModel
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseSubject
import com.unallapps.ehliyetsinavinacalisiyorum.data.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SubjectScreenViewModel @Inject constructor() : ViewModel() {
    private val _lessonSelectedItem: MutableStateFlow<Int> = MutableStateFlow(0)
    val lessonSelectedItem: MutableStateFlow<Int> = _lessonSelectedItem

    private val _selectedSubject: MutableStateFlow<Subject> =
        MutableStateFlow(DatabaseSubject.subjectLists[lessonSelectedItem.value])
    val selectedSubject: MutableStateFlow<Subject> = _selectedSubject

    private val _alertDialog: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val alertDialog: MutableStateFlow<Boolean> = _alertDialog

    fun setSelectedSubject(lessonSelectedItem: Int) {
        _lessonSelectedItem.value = lessonSelectedItem
    }

    fun setAlertDialog(alertDialog: Boolean) {
        _alertDialog.value = alertDialog
    }
}