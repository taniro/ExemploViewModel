package br.ufrn.eaj.tads.exemploviewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ContViewModel (var cont: Int = 0) : ViewModel() {
    val notificadorCont = MutableLiveData<Int>()

    fun incrementa() {
        notificadorCont.value = ++cont
    }
}