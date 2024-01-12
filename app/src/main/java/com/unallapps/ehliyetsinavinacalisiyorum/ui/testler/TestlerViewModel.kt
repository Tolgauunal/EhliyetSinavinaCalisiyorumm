package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestlerRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestlerViewModel @Inject constructor(private val testlerRepository: TestlerRepository) : ViewModel() {
    private var _firebaseListState: MutableStateFlow<TestlerState> = MutableStateFlow(TestlerState.Idle)
    val firebaseListState: MutableStateFlow<TestlerState> = _firebaseListState
    private var isProgressBar = false
    fun testlerList(dersAdi: String) {
        viewModelScope.launch {
            if (!isProgressBar) {
                _firebaseListState.value = TestlerState.Loading
                delay(500)
            }
            isProgressBar = true
            _firebaseListState.value = TestlerState.result(testlerRepository.getTestlerData(dersAdi))
        }
    }

    fun navigate(navController: NavHostController) {
        navController.navigate("testler")
    }
}