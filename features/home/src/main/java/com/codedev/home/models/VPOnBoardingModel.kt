package com.codedev.home.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.codedev.home.R
import com.codedev.ui_base_lib.R as base_R

data class VPOnBoardingModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    @StringRes val description: Int,
    @DrawableRes val icon: Int
) {

    companion object {
        val items = listOf<VPOnBoardingModel>(
            VPOnBoardingModel(
                id = 1,
                title = "Welcome",
                subtitle = "IN REALTIME",
                description = base_R.string.welcome_description,
                icon = R.drawable.ic_welcome
            ),
            VPOnBoardingModel(
                id = 2,
                title = "Dictionary",
                subtitle = "IN REALTIME",
                description = base_R.string.dictionary_description,
                icon = R.drawable.ic_dictionary
            ),
            VPOnBoardingModel(
                id = 3,
                title = "Translator",
                subtitle = "IN REALTIME",
                description = base_R.string.translation_description,
                icon = R.drawable.ic_translator
            ),
            VPOnBoardingModel(
                id = 4,
                title = "AI Chat bot",
                subtitle = "IN REALTIME",
                description = base_R.string.ai_description,
                icon = R.drawable.ic_ai
            ),
        )
    }

}
