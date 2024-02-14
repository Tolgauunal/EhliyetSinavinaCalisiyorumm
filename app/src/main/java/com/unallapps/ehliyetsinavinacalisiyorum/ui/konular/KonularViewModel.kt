package com.unallapps.ehliyetsinavinacalisiyorum.ui.konular

import androidx.lifecycle.ViewModel
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseKonular
import com.unallapps.ehliyetsinavinacalisiyorum.data.Konular
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class KonularViewModel @Inject constructor() : ViewModel() {
    private val _derslerSelectedItem: MutableStateFlow<Int> = MutableStateFlow(0)
    val derslerSelectedItem: MutableStateFlow<Int> = _derslerSelectedItem

    private val _selectedKonu: MutableStateFlow<Konular> =
        MutableStateFlow(DatabaseKonular.konularList[derslerSelectedItem.value])
    val selectedKonu: MutableStateFlow<Konular> = _selectedKonu

    private val _alertDialog: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val alertDialog : MutableStateFlow<Boolean> = _alertDialog
}