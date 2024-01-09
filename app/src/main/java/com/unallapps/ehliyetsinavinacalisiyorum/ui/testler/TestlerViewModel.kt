package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestlerRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestlerViewModel @Inject constructor(private val testlerRepository: TestlerRepository) :
    ViewModel() {
    var stateFlow: MutableStateFlow<TestlerState> = MutableStateFlow(TestlerState.Idle)
    fun testlerList(dersAdi:String) {
        viewModelScope.launch {
            stateFlow.value = TestlerState.result(testlerRepository.getTestlerData(dersAdi))
        }
    }
}