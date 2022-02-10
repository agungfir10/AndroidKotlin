package com.agungfir.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    private val _name: MutableLiveData<String> = MutableLiveData<String>("Agung")
    var name: LiveData<String> = _name

    fun changeName(name: String) {
        _name.value = name
    }
}