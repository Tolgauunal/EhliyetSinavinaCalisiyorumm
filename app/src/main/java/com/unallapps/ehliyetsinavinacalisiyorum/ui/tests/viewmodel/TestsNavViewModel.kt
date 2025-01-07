package com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestSaveIdRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestsNavViewModel @Inject constructor(private val testSaveIdRepository: TestSaveIdRepository) :
    ViewModel() {
    private val _selectedLessonItemIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedLessonItemIndex: MutableStateFlow<Int> = _selectedLessonItemIndex

    private val _selectedLessonItemText: MutableStateFlow<String?> = MutableStateFlow(null)
    val selectedLessonItemText: MutableStateFlow<String?> = _selectedLessonItemText
    private val testIdNameList =
        listOf(
            TestSaveIdEntity(1, Constants.String.FIRST_AID),
            TestSaveIdEntity(2, Constants.String.TRAFFIC),
            TestSaveIdEntity(3, Constants.String.ENGINE)
        )

    init {
        viewModelScope.launch {
            val testList = testSaveIdRepository.getTestList()
            if (testList.isEmpty()) {
                testIdNameList.forEach {
                    testSaveIdRepository.insert(it)
                }
            }
        }
    }

    fun defaultTestItem(lessonName: String) {
        viewModelScope.launch {
            testSaveIdRepository.updateTestSave(
                0, lessonName = lessonName, 0,
                0, 0
            )
        }
    }

    fun setSelectedLessonItemText(data: String) {
        _selectedLessonItemText.value = data
    }

    fun setSelectedLessonItemIndex(data: Int) {
        _selectedLessonItemIndex.value = data
    }
}