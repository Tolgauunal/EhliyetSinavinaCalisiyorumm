package com.unallapps.ehliyetsinavinacalisiyorum.ui.bilgikartlari

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.InformationCardsInfo
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.InformationCardiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InformationCardViewModel @Inject constructor(val informationCardiRepository: InformationCardiRepository) :
    ViewModel() {
    private var _informationCardsInfo: MutableStateFlow<List<InformationCardsInfo>?> =
        MutableStateFlow(null)
    var informationCardsInfo: StateFlow<List<InformationCardsInfo>?> = _informationCardsInfo
    private var _informationCardsSize: MutableStateFlow<Float?> =
        MutableStateFlow(null)
    var informationCardsSize: StateFlow<Float?> = _informationCardsSize
    fun getInformationCard(subjectName: String) {
        viewModelScope.launch {
            informationCardiRepository.getKonu(subjectName)?.let {
                _informationCardsInfo.value = it.lessonInformationCards
                it.lessonInformationCards?.size?.let {
                    _informationCardsSize.value = it.toFloat()
                }
            }
        }
    }
}