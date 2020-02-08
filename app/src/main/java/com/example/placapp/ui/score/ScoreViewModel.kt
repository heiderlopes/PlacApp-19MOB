package com.example.placapp.ui.score

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    val goalHome = MutableLiveData<Int>()
    val goalAway = MutableLiveData<Int>()

    init {
        initGame()
    }

    fun initGame() {
        goalHome.value = 0
        goalAway.value = 0
    }

    fun restartGame() {
        initGame()
    }

    fun goalHome() {
        goalHome.value = goalHome.value?.plus(1)
    }

    fun goalAway() {
        goalAway.value = goalAway.value?.plus(1)
    }

}
