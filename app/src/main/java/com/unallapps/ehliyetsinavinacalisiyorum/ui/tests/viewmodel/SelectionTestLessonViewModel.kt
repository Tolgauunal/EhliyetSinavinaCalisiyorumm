package com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseTestList
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.LessonRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestDetailRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectionTestLessonViewModel @Inject constructor(
    private val lessonRepository: LessonRepository,
    private val testDetailRepository: TestDetailRepository,
) : ViewModel() {

    private val _selectedLessonIndex = MutableStateFlow(0)
    val selectedLessonIndex: StateFlow<Int> = _selectedLessonIndex

    private val _selectedLessonName = MutableStateFlow<String?>(Constants.String.FIRST_AID)
    val selectedLessonName: StateFlow<String?> = _selectedLessonName

    private val _isFavoriteCardVisible = MutableStateFlow(false)
    val isFavoriteCardVisible: StateFlow<Boolean> = _isFavoriteCardVisible

    private val defaultTestLessons = listOf(
        TestSaveIdEntity(1, Constants.String.FIRST_AID),
        TestSaveIdEntity(2, Constants.String.TRAFFIC),
        TestSaveIdEntity(4, Constants.String.ENGINE),
        TestSaveIdEntity(3, Constants.String.FAVORITE)
    )

    init {
        viewModelScope.launch {
            val savedLessons = lessonRepository.getSavedInfoTestLesson()
            if (savedLessons.isEmpty()) {
                defaultTestLessons.forEach {
                    lessonRepository.insertLesson(it)
                }
            }

            val testList = testDetailRepository.getAllTestListSize()
            if (testList.isNullOrEmpty()) {
                testDetailRepository.insertTestList(DatabaseTestList.TestList)
            }

            _isFavoriteCardVisible.value = testList?.any { it.favorite } ?: false
        }
    }

    fun resetLessonInfo(lessonName: String) {
        viewModelScope.launch {
            lessonRepository.updateLessonDetailInfo(
                testNumber = 0, lessonName = lessonName, correctSum = 0,
                wrongSum = 0, questionNumber = 0
            )
        }
    }

    fun selectLessonName(name: String) {
        _selectedLessonName.value = name
    }

    fun selectLessonIndex(index: Int) {
        _selectedLessonIndex.value = index
    }
}