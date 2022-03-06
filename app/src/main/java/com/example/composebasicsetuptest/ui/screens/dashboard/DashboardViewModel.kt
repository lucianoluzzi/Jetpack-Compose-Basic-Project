package com.example.composebasicsetuptest.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import com.example.composebasicsetuptest.R
import com.example.composebasicsetuptest.domain.model.Muscle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {
    private val _muscles = MutableStateFlow(
        listOf(
            Muscle(
                name = "Biceps",
                iconResource = R.drawable.icon_biceps
            ),
            Muscle("Triceps"),
            Muscle("Forearms"),
            Muscle("Shoulders"),
            Muscle("Front Deltoid"),
            Muscle("Lateral Deltoid"),
            Muscle("Posterial Deltoid"),
        )
    )
    val muscles: StateFlow<List<Muscle>> = _muscles
}