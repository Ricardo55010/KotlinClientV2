package com.example.kotlinclientv2.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
class SettingsViewModel : ViewModel() {
    // Primer LiveData para el TextView principal
    private val _text = MutableLiveData<String>().apply {
        value = "Initial text"
    }
    val text: LiveData<String> = _text

    private val _secondText = MutableLiveData<String>().apply {
        value = "Secondary text"
    }
    val secondText: LiveData<String> = _secondText


    fun updateTexts(main: String, secondary: String) {
        _text.value = main
        _secondText.value = secondary
    }
}