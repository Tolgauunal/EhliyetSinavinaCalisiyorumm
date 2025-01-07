package com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestSaveIdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestsNavViewModel @Inject constructor(val testSaveIdRepository: TestSaveIdRepository) :
    ViewModel() {
    private val _selectedLessonItemIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedLessonItemIndex: MutableStateFlow<Int> = _selectedLessonItemIndex

    private val _selectedLessonItemText: MutableStateFlow<String> = MutableStateFlow("İlk Yardım")
    val selectedLessonItemText: MutableStateFlow<String> = _selectedLessonItemText
    private val testIdNameList =
        listOf(
            TestSaveIdEntity(1, "İlk Yardım"),
            TestSaveIdEntity(2, "Trafik"),
            TestSaveIdEntity(3, "Motor")
        )

    init {
        viewModelScope.launch {
            val testListesi = testSaveIdRepository.getTestList()
            if (testListesi.isEmpty()) {
                testIdNameList.forEach {
                    testSaveIdRepository.insert(it)
                }
            }
        }
    }

    fun defaultTestItem(dersAdi: String) {
        viewModelScope.launch {
            testSaveIdRepository.updateTestSave(0, lessonName = dersAdi, 0, 0, 0)
        }
    }

    fun setSelectedLessonItemText(data: String) {
        _selectedLessonItemText.value = data
    }
    fun setSelectedLessonItemIndex(data: Int) {
        _selectedLessonItemIndex.value = data
    }
}