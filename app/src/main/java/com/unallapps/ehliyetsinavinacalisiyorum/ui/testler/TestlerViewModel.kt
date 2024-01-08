package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
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
    init {
        testlerList()
    }
    fun testlerList() {
        viewModelScope.launch {
            stateFlow.value = TestlerState.result(testlerRepository.getTestlerData())
        }
    }
}