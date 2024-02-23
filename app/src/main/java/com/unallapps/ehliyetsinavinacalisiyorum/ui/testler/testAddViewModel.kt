package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestAddRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class testAddViewModel @Inject constructor(private val testRepository: TestAddRepository) : ViewModel() {
    private val _addTest: MutableSharedFlow<TestlerEntity> = MutableSharedFlow()
    val addTest: SharedFlow<TestlerEntity> = _addTest

    fun addTest(a: String, b: String, c: String, d: String, soru: String, cevap: String, testId: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                val addTest = TestlerEntity(testId.toInt(), soru, null, a, b, c, d, cevap)
                testRepository.addTest(addTest)
            }.onFailure {}
        }
    }
}