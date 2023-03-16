package com.codedev.home.models

import androidx.annotation.DrawableRes
import com.codedev.base.R as base_R

data class RVFeatureModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    @DrawableRes val icon: Int
) {
    companion object {
        val items = listOf<RVFeatureModel>(
            RVFeatureModel(
                id = 1,
                title = "Dictionary",
                subtitle = "Improve your vocabulary, this feature provides definitions, spellings, pronunciations, and other information about words and phrases in a language.",
                icon = base_R.drawable.ic_opt_dictionary
            ),
            RVFeatureModel(
                id = 2,
                title = "Voice Translator",
                subtitle = "Translate spoken words from one language to another in real-time. It is a powerful tool that helps you communicate with people who speak different languages.",
                icon = base_R.drawable.ic_opt_translator
            ),
            RVFeatureModel(
                id = 1,
                title = "Chat AI",
                subtitle = "AI chat is an artificial intelligence-powered program or system that can interact with users through text-based messaging, providing instant responses to queries, questions, or commands.",
                icon = base_R.drawable.ic_opt_ai
            )
        )
    }
}
