package com.unallapps.ehliyetsinavinacalisiyorum.ui.informationCard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.InformationCardsInfo
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.InformationCardRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InformationCardViewModel @Inject constructor(
    private val repository: InformationCardRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _cards: MutableStateFlow<List<InformationCardsInfo>?> = MutableStateFlow(null)
    val cards: StateFlow<List<InformationCardsInfo>?> = _cards

    private val _totalCards: MutableStateFlow<Float?> = MutableStateFlow(null)
    val totalCards: StateFlow<Float?> = _totalCards

    private val _progressIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    val progressIndex: StateFlow<Int> = _progressIndex

    private val _showForwardIcon: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val showForwardIcon: StateFlow<Boolean> = _showForwardIcon

    private val _showBackIcon: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showBackIcon: StateFlow<Boolean> = _showBackIcon

    private val _subjectName: MutableStateFlow<String?> = MutableStateFlow(null)

    init {
        savedStateHandle.get<String>(Constants.String.SUBJECT_NAME)?.let {
            _subjectName.value = it
        }
        loadInformationCards()
    }

    private fun loadInformationCards() {
        viewModelScope.launch {
            _subjectName.value?.let { subjectName ->
                repository.getSubject(subjectName)?.let { subject ->
                    _cards.value = subject.lessonInformationCards
                    _totalCards.value = subject.lessonInformationCards?.size?.toFloat()
                }
            }
        }
    }

    fun updateProgress(index: Int) {
        _progressIndex.value = index
        _showForwardIcon.value = _totalCards.value?.toInt() != _progressIndex.value + 1
        _showBackIcon.value = _progressIndex.value != 0
    }
}