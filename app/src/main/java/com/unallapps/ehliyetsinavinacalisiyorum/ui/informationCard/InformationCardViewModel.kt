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
    private val informationCardRepository: InformationCardRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _informationCardsInfo: MutableStateFlow<List<InformationCardsInfo>?> =
        MutableStateFlow(null)
    val informationCardsInfo: StateFlow<List<InformationCardsInfo>?> = _informationCardsInfo

    private val _informationCardsSize: MutableStateFlow<Float?> =
        MutableStateFlow(null)
    val informationCardsSize: StateFlow<Float?> = _informationCardsSize

    private val _subjectName: MutableStateFlow<String?> =
        MutableStateFlow(null)

    private val _progressBarCount: MutableStateFlow<Int> =
        MutableStateFlow(0)
    val progressBarCount: StateFlow<Int> = _progressBarCount

    private val _forwardIconShow: MutableStateFlow<Boolean> =
        MutableStateFlow(true)
    val forwardIconShow: StateFlow<Boolean> = _forwardIconShow

    private val _backIconShow: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val backIconShow: StateFlow<Boolean> = _backIconShow

    init {
        savedStateHandle.get<String>(Constants.String.SUBJECT_NAME)?.let {
            _subjectName.value = it
        }
        getInformationCard()
    }

    private fun getInformationCard() {
        viewModelScope.launch {
            _subjectName.value?.let {
                informationCardRepository.getSubject(it)?.let { subject ->
                    _informationCardsInfo.value = subject.lessonInformationCards
                    subject.lessonInformationCards?.size?.let { subjectSize ->
                        _informationCardsSize.value = subjectSize.toFloat()
                    }
                }
            }
        }
    }

    fun setProgressBarCount(data: Int) {
        _progressBarCount.value = data
        _forwardIconShow.value = _informationCardsSize.value?.toInt() != _progressBarCount.value + 1
        _backIconShow.value = 0 != _progressBarCount.value
    }
}