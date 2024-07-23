package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseLesson
import com.unallapps.ehliyetsinavinacalisiyorum.data.Lesson
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(private val testRepository: TestRepository) : ViewModel() {
    private val _getSelectedLessonInfo: MutableStateFlow<Lesson?> = MutableStateFlow(null)
    val getSelectedLessonInfo = _getSelectedLessonInfo.asStateFlow()
    private val _questionIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    val questionIndex = _questionIndex.asStateFlow()
    private val _questionSize: MutableStateFlow<Int> = MutableStateFlow(0)
    val questionSize = _questionSize.asStateFlow()
    private val _question: MutableStateFlow<String> = MutableStateFlow("")
    val question = _question.asStateFlow()
    private val _correct: MutableStateFlow<String> = MutableStateFlow("")
    val correct = _correct.asStateFlow()


    private val _correctControl: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val correctControl = _correctControl.asStateFlow()
    private val _selectedCorrect: MutableStateFlow<String?> = MutableStateFlow(null)
    val selectedCorrect = _selectedCorrect.asStateFlow()

    private val _correctSum: MutableStateFlow<Int> = MutableStateFlow(0)
    val correctSum = _correctSum.asStateFlow()
    private val _wrongSum: MutableStateFlow<Int> = MutableStateFlow(0)
    val wrongSum = _wrongSum.asStateFlow()

    private val _questionImage: MutableStateFlow<Int?> = MutableStateFlow(null)
    val questionImage: StateFlow<Int?> = _questionImage

    private val _closeTest: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val closeTest = _closeTest.asStateFlow()
    private val _finishAlertDialog: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val finishAlertDialog = _finishAlertDialog.asStateFlow()
    private val _exitAlertDialog: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val exitAlertDialog = _exitAlertDialog.asStateFlow()
    private val _testIcon: MutableStateFlow<List<Int>> =
        MutableStateFlow(listOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d))
    val testIcon = _testIcon.asStateFlow()
    private val _optionA: MutableStateFlow<String> = MutableStateFlow("")
    val optionA = _optionA.asStateFlow()
    private val _optionB: MutableStateFlow<String> = MutableStateFlow("")
    val optionB = _optionB.asStateFlow()
    private val _optionC: MutableStateFlow<String> = MutableStateFlow("")
    val optionC = _optionC.asStateFlow()
    private val _optionD: MutableStateFlow<String> = MutableStateFlow("")
    val optionD = _optionD.asStateFlow()
    private val _backgroundColorA: MutableStateFlow<Int?> = MutableStateFlow(null)
    val backgroundColorA = _backgroundColorA.asStateFlow()
    private val _backgroundColorB: MutableStateFlow<Int?> = MutableStateFlow(null)
    val backgroundColorB = _backgroundColorB.asStateFlow()
    private val _backgroundColorC: MutableStateFlow<Int?> = MutableStateFlow(null)
    val backgroundColorC = _backgroundColorC.asStateFlow()
    private val _backgroundColorD: MutableStateFlow<Int?> = MutableStateFlow(null)
    val backgroundColorD = _backgroundColorD.asStateFlow()

    fun getTestList(lessonName: String) {
        viewModelScope.launch {
            testRepository.getTestlerData(lessonName, _questionIndex.value)?.let {
                _questionSize.value = it.size
                _question.value = it[_questionIndex.value].content.toString()
                _correct.value = it[_questionIndex.value].correct.toString()
                it[_questionIndex.value].imageTest?.let { image ->
                    _questionImage.value = image
                }
                _optionA.value = it[_questionIndex.value].atest.toString()
                _optionB.value = it[_questionIndex.value].btest.toString()
                _optionC.value = it[_questionIndex.value].ctest.toString()
                _optionD.value = it[_questionIndex.value].dtest.toString()
            }
        }
    }

    fun setSelectedCorrect(selectedCorrect: String) {
        _selectedCorrect.value = selectedCorrect
        checkCorrectOrWrongControl()
    }

    private fun checkCorrectOrWrongControl() {
        _selectedCorrect.value?.let {
            if (_correct.value == it) {
                _correctSum.value += 1
                _correctControl.value = true
                when (it) {
                    _optionA.value -> _backgroundColorA.value = R.color.DarkGreen
                    _optionB.value -> _backgroundColorB.value = R.color.DarkGreen
                    _optionC.value -> _backgroundColorC.value = R.color.DarkGreen
                    _optionD.value -> _backgroundColorD.value = R.color.DarkGreen
                }
            } else {
                _wrongSum.value += 1
                _correctControl.value = false
                when (it) {
                    _optionA.value -> _backgroundColorA.value = R.color.DarkRed
                    _optionB.value -> _backgroundColorB.value = R.color.DarkRed
                    _optionC.value -> _backgroundColorC.value = R.color.DarkRed
                    _optionD.value -> _backgroundColorD.value = R.color.DarkRed
                }
                when (_correct.value) {
                    _optionA.value -> _backgroundColorA.value = R.color.DarkGreen
                    _optionB.value -> _backgroundColorB.value = R.color.DarkGreen
                    _optionC.value -> _backgroundColorC.value = R.color.DarkGreen
                    _optionD.value -> _backgroundColorD.value = R.color.DarkGreen
                }
            }
        }
    }

    fun getSelectedLesson(lessonName: String) {
        DatabaseLesson.derslerList.forEach {
            if (it.name == lessonName) {
                _getSelectedLessonInfo.value = it
            }
        }

    }

    fun nextQuestion() {
        if (_questionIndex.value != _questionSize.value - 1) {
            _backgroundColorA.value = R.color.white
            _backgroundColorB.value = R.color.white
            _backgroundColorC.value = R.color.white
            _backgroundColorD.value = R.color.white
            _questionIndex.value += 1
        } else {
            setFinishAlertDialog(true)
        }
    }

    fun setFinishAlertDialog(finishAlertDialog: Boolean) {
        _finishAlertDialog.value = finishAlertDialog
    }

    fun setExitAlertDialog(exitAlertDialog: Boolean) {
        _finishAlertDialog.value = exitAlertDialog
    }
}