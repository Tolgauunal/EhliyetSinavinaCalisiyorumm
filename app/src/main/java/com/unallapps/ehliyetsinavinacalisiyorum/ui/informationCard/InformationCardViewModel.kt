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
    val informationCardRepository: InformationCardRepository,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private var _informationCardsInfo: MutableStateFlow<List<InformationCardsInfo>?> =
        MutableStateFlow(null)
    var informationCardsInfo: StateFlow<List<InformationCardsInfo>?> = _informationCardsInfo
    private var _informationCardsSize: MutableStateFlow<Float?> =
        MutableStateFlow(null)
    var informationCardsSize: StateFlow<Float?> = _informationCardsSize
    private var _subjectName: MutableStateFlow<String?> =
        MutableStateFlow(null)

    init {
        savedStateHandle.get<String>(Constants.STRING.SUBJECT_NAME)?.let {
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
}