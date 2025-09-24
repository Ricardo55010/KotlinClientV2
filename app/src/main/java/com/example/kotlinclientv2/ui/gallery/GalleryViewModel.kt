package com.example.kotlinclientv2.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {//defining the livestate
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    private val _secondText = MutableLiveData<String>().apply {//defining the livestate
        value = "This is a secondary test"
    }
    val secondText: LiveData<String> = _secondText
}