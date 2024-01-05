package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestlerViewModel @Inject constructor(private val testlerRepository: TestlerRepository):ViewModel() {
    fun getAllTest() {
        viewModelScope.launch {
            testlerRepository.getTest()
        }
    }
}