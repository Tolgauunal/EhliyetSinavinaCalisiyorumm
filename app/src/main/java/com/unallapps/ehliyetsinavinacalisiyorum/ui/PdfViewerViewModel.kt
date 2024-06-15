package com.unallapps.ehliyetsinavinacalisiyorum.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.storage.FirebaseStorage
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestSaveIdRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestlerRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class PdfviewerViewModel @Inject constructor(private val testlerRepository: TestlerRepository,
    private val testSaveIdRepository: TestSaveIdRepository) : ViewModel() {
    private var _firebaseListState: MutableStateFlow<TestlerState> = MutableStateFlow(TestlerState.Idle)
    val firebaseListState: MutableStateFlow<TestlerState> = _firebaseListState
    private var _link: MutableStateFlow<ByteArray?> = MutableStateFlow(null)
    val link: MutableStateFlow<ByteArray?> = _link
    private var _testIdData: MutableStateFlow<TestSaveIdEntity?> = MutableStateFlow(null)
    val testIdData: MutableStateFlow<TestSaveIdEntity?> = _testIdData
    private var isProgressBar = false
    val pdfFile :MutableStateFlow<ByteArray?> = MutableStateFlow(null)
    fun firebaseTestList() {
        viewModelScope.launch {
            if (!isProgressBar) {
                _firebaseListState.value = TestlerState.Loading
                delay(500)
            }
            isProgressBar = true
            _firebaseListState.value = TestlerState.resultPdf(testlerRepository.getPdf())
        }
    }
    init {
        firebaseTestList()
    }
}