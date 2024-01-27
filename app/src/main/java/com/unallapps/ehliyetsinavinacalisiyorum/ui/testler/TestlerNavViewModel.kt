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
class TestlerNavViewModel @Inject constructor(val testSaveIdRepository: TestSaveIdRepository) : ViewModel() {
    private val _testAlertControl: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val testAlertControl: MutableStateFlow<Boolean?> = _testAlertControl
    private val testIdNameList =
        listOf(TestSaveIdEntity(1, "İlk Yardım", 0), TestSaveIdEntity(2, "Trafik", 0), TestSaveIdEntity(3, "Motor", 0))

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

    fun getAlertDialogControl(dersAdi: String) {
        viewModelScope.launch {
            testSaveIdRepository.getTestData(dersAdi = dersAdi)?.let {
                if (it.soruSize != 0) {
                    _testAlertControl.value = true
                }
            } ?: run {
                _testAlertControl.value = false
            }
        }
    }

    fun defaultTestItem(dersAdi: String) {
        viewModelScope.launch {
            testSaveIdRepository.updateTestSave(0, dersAdi = dersAdi, 0, 0, 0)
        }
    }
}