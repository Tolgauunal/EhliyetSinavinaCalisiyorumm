package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestSaveIdRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestlerRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestlerViewModel @Inject constructor(private val testlerRepository: TestlerRepository,
    private val testSaveIdRepository: TestSaveIdRepository) : ViewModel() {
    private var _firebaseListState: MutableStateFlow<TestlerState> = MutableStateFlow(TestlerState.Idle)
    val firebaseListState: MutableStateFlow<TestlerState> = _firebaseListState
    private var _testIdData: MutableStateFlow<TestSaveIdEntity?> = MutableStateFlow(null)
    val testIdData: MutableStateFlow<TestSaveIdEntity?> = _testIdData
    private var _isProgressBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isProgressBar: MutableStateFlow<Boolean> = _isProgressBar
    private var _soruKontrol: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val soruKontrol: MutableStateFlow<Boolean> = _soruKontrol
    private var _uiDurum: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val uiDurum: MutableStateFlow<Boolean> = _uiDurum
    private var _showIcon: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showIcon: MutableStateFlow<Boolean> = _showIcon
    private var _soruIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    val soruIndex: MutableStateFlow<Int> = _soruIndex
    private var _testerSize: MutableStateFlow<Int> = MutableStateFlow(0)
    val testerSize: MutableStateFlow<Int> = _testerSize
    fun firebaseTestList(dersAdi: String, testNum: Int) {
        viewModelScope.launch {
            if (!isProgressBar.value) {
                _firebaseListState.value = TestlerState.Loading
                delay(500)
            }
            _isProgressBar.value = true
            _firebaseListState.value = TestlerState.result(testlerRepository.getTestlerData(dersAdi, testNum))
            testerSize.value = testlerRepository.getTestlerData(dersAdi, testNum).size
        }
    }

    fun getTestIdData(konuAdi: String) {
        viewModelScope.launch {
            testSaveIdRepository.getTestData(konuAdi)?.let {
                _testIdData.value = it
            }
        }
    }

    fun saveTestId(soruNumarasi: Int, dersAdi: String, dogruCevapSayisi: Int, yanlisCevapSayisi: Int, soruSize: Int) {
        viewModelScope.launch {
            val testListesi = testSaveIdRepository.getTestList()
            if (testListesi.isNotEmpty()) {
                testSaveIdRepository.updateTestSave(testNum = soruNumarasi,
                    dersAdi = dersAdi,
                    dogruCevapSayisi = dogruCevapSayisi,
                    yanlisCevapSayisi = yanlisCevapSayisi,
                    soruSize = soruSize)
            }
        }
    }
}