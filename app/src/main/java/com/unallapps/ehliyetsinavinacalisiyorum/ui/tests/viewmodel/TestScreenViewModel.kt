package com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseLesson
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseTestList
import com.unallapps.ehliyetsinavinacalisiyorum.data.Lesson
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestsEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestDetailRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.LessonRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestScreenViewModel @Inject constructor(
    private val testDetailRepository: TestDetailRepository,
    private val lessonRepository: LessonRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // region === State ===
    private val _selectedLesson: MutableStateFlow<Lesson?> = MutableStateFlow(null)
    val selectedLesson = _selectedLesson.asStateFlow()

    private val _currentLessonName: MutableStateFlow<String> = MutableStateFlow("")
    private val _restartOrContinue: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    private val _continueTestInfo: MutableStateFlow<TestSaveIdEntity?> = MutableStateFlow(null)

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex = _currentQuestionIndex.asStateFlow()

    private val _totalQuestionCount = MutableStateFlow(0)
    val totalQuestionCount = _totalQuestionCount.asStateFlow()

    private val _currentQuestionText = MutableStateFlow("")
    val currentQuestionText = _currentQuestionText.asStateFlow()

    private val _correctAnswer = MutableStateFlow("")
    private val _selectedAnswer = MutableStateFlow<String?>(null)
    private val _isAnswerCorrect = MutableStateFlow(false)

    private val _correctAnswerCount = MutableStateFlow(0)
    val correctAnswerCount = _correctAnswerCount.asStateFlow()

    private val _wrongAnswerCount = MutableStateFlow(0)
    val wrongAnswerCount = _wrongAnswerCount.asStateFlow()

    private val _questionImageRes = MutableStateFlow<Int?>(null)
    val questionImageRes: StateFlow<Int?> = _questionImageRes

    private val _optionAText = MutableStateFlow("")
    val optionAText = _optionAText.asStateFlow()

    private val _optionBText = MutableStateFlow("")
    val optionBText = _optionBText.asStateFlow()

    private val _optionCText = MutableStateFlow("")
    val optionCText = _optionCText.asStateFlow()

    private val _optionDText = MutableStateFlow("")
    val optionDText = _optionDText.asStateFlow()

    private val _optionAColor = MutableStateFlow<Int?>(null)
    val optionAColor = _optionAColor.asStateFlow()

    private val _optionBColor = MutableStateFlow<Int?>(null)
    val optionBColor = _optionBColor.asStateFlow()

    private val _optionCColor = MutableStateFlow<Int?>(null)
    val optionCColor = _optionCColor.asStateFlow()

    private val _optionDColor = MutableStateFlow<Int?>(null)
    val optionDColor = _optionDColor.asStateFlow()

    private val _isQuestionClickable = MutableStateFlow(true)

    private val _showFinishDialog = MutableStateFlow(false)
    val showFinishDialog = _showFinishDialog.asStateFlow()

    private val _showExitDialog = MutableStateFlow(false)
    val showExitDialog = _showExitDialog.asStateFlow()

    private val _showNextButton = MutableStateFlow(false)
    val showNextButton = _showNextButton.asStateFlow()

    private val _isFavorite = MutableStateFlow(false)

    private val _favoriteIconRes = MutableStateFlow(R.drawable.unfavorite)
    val favoriteIconRes = _favoriteIconRes.asStateFlow()

    private val _currentTestEntity = MutableStateFlow<TestsEntity?>(null)

    init {
        savedStateHandle.get<String>(Constants.String.LESSON_NAME)?.let {
            _currentLessonName.value = it
        }
        savedStateHandle.get<Boolean>(Constants.String.RESTART_OR_CONTINUE)?.let {
            _restartOrContinue.value = it
        }
        loadTestsForLesson()
        loadSelectedLessonInfo()
    }

    private fun loadTestsForLesson() {
        viewModelScope.launch {
            if (_restartOrContinue.value == true) {
                _continueTestInfo.value = lessonRepository.getLessonData(_currentLessonName.value)
                _continueTestInfo.value?.let {
                    _currentQuestionIndex.value = it.testNumber
                    _correctAnswerCount.value = it.correctSize
                    _wrongAnswerCount.value = it.wrongSize
                    _restartOrContinue.value = false
                }
            }

            val testList = testDetailRepository.getTestDetailList(_currentLessonName.value)
            if (testList.isNullOrEmpty()) {
                testDetailRepository.insertTestList(DatabaseTestList.TestList)
                loadCurrentQuestionData()
            } else {
                loadCurrentQuestionData()
            }
        }
    }

    private fun loadSelectedLessonInfo() {
        DatabaseLesson.lessonList.forEach {
            if (it.name == _currentLessonName.value) {
                _selectedLesson.value = it
            }
        }
    }

    private fun loadCurrentQuestionData() {
        viewModelScope.launch {
            if (_currentLessonName.value != Constants.String.FAVORITE) {
                val testList = testDetailRepository.getTestDetailList(_currentLessonName.value)
                testList?.let {
                    val current = it[_currentQuestionIndex.value]
                    _currentTestEntity.value = current
                    _totalQuestionCount.value = it.size
                    _isFavorite.value = current.favorite
                    updateFavoriteIcon()

                    _currentQuestionText.value = current.content.orEmpty()
                    _correctAnswer.value = current.correct.orEmpty()
                    _questionImageRes.value = current.imageTest

                    _optionAText.value = current.aTest.orEmpty()
                    _optionBText.value = current.bTest.orEmpty()
                    _optionCText.value = current.cTest.orEmpty()
                    _optionDText.value = current.dTest.orEmpty()
                }
            } else {
                val testList = testDetailRepository.getFavoriteTestList()
                testList?.let {
                    val current = it[_currentQuestionIndex.value]
                    _currentTestEntity.value = current
                    _totalQuestionCount.value = it.size
                    _isFavorite.value = current.favorite
                    updateFavoriteIcon()

                    _currentQuestionText.value = current.content.orEmpty()
                    _correctAnswer.value = current.correct.orEmpty()
                    _questionImageRes.value = current.imageTest

                    _optionAText.value = current.aTest.orEmpty()
                    _optionBText.value = current.bTest.orEmpty()
                    _optionCText.value = current.cTest.orEmpty()
                    _optionDText.value = current.dTest.orEmpty()
                }
            }
        }
    }

    fun selectAnswer(answer: String) {
        _selectedAnswer.value = answer
        _showNextButton.value = true
        evaluateAnswer()
    }

    private fun evaluateAnswer() {
        _selectedAnswer.value?.let { selected ->
            if (_correctAnswer.value == selected) {
                _correctAnswerCount.value += 1
                _isAnswerCorrect.value = true
                markAnswerColor(selected, true)
            } else {
                _wrongAnswerCount.value += 1
                _isAnswerCorrect.value = false
                markAnswerColor(selected, false)
                markAnswerColor(_correctAnswer.value, true)
            }
        }
    }

    private fun markAnswerColor(answer: String, isCorrect: Boolean) {
        val colorRes = if (isCorrect) R.color.DarkGreen else R.color.DarkRed
        when (answer) {
            _optionAText.value -> _optionAColor.value = colorRes
            _optionBText.value -> _optionBColor.value = colorRes
            _optionCText.value -> _optionCColor.value = colorRes
            _optionDText.value -> _optionDColor.value = colorRes
        }
    }

    fun nextQuestion() {
        _selectedAnswer.value?.let {
            if (_currentQuestionIndex.value < _totalQuestionCount.value - 1) {
                resetOptionColors()
                _currentQuestionIndex.value += 1
                _selectedAnswer.value = null
            } else {
                _isQuestionClickable.value = false
                _showFinishDialog.value = true
            }
        }
        loadCurrentQuestionData()
        _showNextButton.value = false
    }

    private fun resetOptionColors() {
        _optionAColor.value = R.color.white
        _optionBColor.value = R.color.white
        _optionCColor.value = R.color.white
        _optionDColor.value = R.color.white
    }

    fun toggleFavoriteStatus() {
        _isFavorite.value = !_isFavorite.value
        updateFavoriteIcon()

        viewModelScope.launch {
            _currentTestEntity.value?.let { test ->
                testDetailRepository.updateFavoriteTest(test.testId, _isFavorite.value)
            }
        }
    }

    private fun updateFavoriteIcon() {
        _favoriteIconRes.value = if (_isFavorite.value) {
            R.drawable.favorite
        } else {
            R.drawable.unfavorite
        }
    }

    fun setFinishDialogVisible(visible: Boolean) {
        _showFinishDialog.value = visible
    }

    fun setExitDialogVisible(visible: Boolean) {
        _showExitDialog.value = visible
    }

    fun saveTestProgress(currentQuestion: Int) {
        viewModelScope.launch {
            lessonRepository.updateLessonDetailInfo(
                currentQuestion,
                _currentLessonName.value,
                _correctAnswerCount.value,
                _wrongAnswerCount.value,
                _totalQuestionCount.value
            )
        }
    }
}