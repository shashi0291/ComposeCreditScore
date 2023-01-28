package com.example.composepractise

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CreditScoreViewModel constructor(
    application: Application
) : AndroidViewModel(application) {

    private var _uiState = MutableStateFlow(CreditScoreUiState())
    val uiState: StateFlow<CreditScoreUiState> = _uiState.asStateFlow()

    fun calculateRotationPercentage(
        creditScore: Int
    ) {
        val percentage = (((creditScore - MIN_CREDIT_SCORE) * 180) / (MAX_CREDIT_SCORE - MIN_CREDIT_SCORE))
        _uiState.value = CreditScoreUiState(rotationPercent = percentage)
    }

    companion object {
        private const val MAX_CREDIT_SCORE = 850
        private const val MIN_CREDIT_SCORE = 300
    }
}