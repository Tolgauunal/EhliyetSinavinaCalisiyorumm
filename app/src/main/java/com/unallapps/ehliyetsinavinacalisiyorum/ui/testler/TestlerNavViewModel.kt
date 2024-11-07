package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestSaveIdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestlerNavViewModel @Inject constructor(val testSaveIdRepository: TestSaveIdRepository) :
    ViewModel() {
    private val _selectedDersItemIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedDersItemIndex: MutableStateFlow<Int> = _selectedDersItemIndex

    private val _selectedDersItemText: MutableStateFlow<String> = MutableStateFlow("İlk Yardım")
    val selectedDersItemText: MutableStateFlow<String> = _selectedDersItemText
    private val testIdNameList =
        listOf(
            TestSaveIdEntity(1, "İlk Yardım", 0),
            TestSaveIdEntity(2, "Trafik", 0),
            TestSaveIdEntity(3, "Motor", 0)
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
}