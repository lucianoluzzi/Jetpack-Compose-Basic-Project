package com.example.composebasicsetuptest.domain.model

import androidx.annotation.DrawableRes
import com.example.composebasicsetuptest.R

data class Muscle(
    val name: String,
    @DrawableRes val iconResource: Int = R.drawable.icons_shoulder
)
