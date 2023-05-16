package com.nikhil.mynewsample.screen.dashboard.ui.askDoubt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AskDoubtViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _text = MutableLiveData<String>().apply {
        value = "This is Ask Doubt Fragment"
    }
    val text: LiveData<String> = _text
}