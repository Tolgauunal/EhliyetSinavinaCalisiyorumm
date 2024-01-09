package com.unallapps.ehliyetsinavinacalisiyorum.ui.bilgikartlari

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.BilgiKartlariRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.KonularState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BilgiKartlariViewModel @Inject constructor(private val bilgiKartlariRepository: BilgiKartlariRepository) : ViewModel(){
    private var stateFlow: MutableStateFlow<KonularState> = MutableStateFlow(KonularState.Idle)
    var _stateFlow: MutableStateFlow<KonularState> = stateFlow
    fun getKonu(konuAdi: String) {
        viewModelScope.launch {
            stateFlow.value= KonularState.Loading
            bilgiKartlariRepository.getKonu(konuAdi)?.let {
                stateFlow.value = KonularState.Result(it)
            }
        }
    }
}