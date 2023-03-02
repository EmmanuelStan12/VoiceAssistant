package com.codedev.api_lib.dictionary.models

data class WordDTO(
    val license: LicenseDTO,
    val meanings: List<MeaningDTO>,
    val phonetic: String,
    val phonetics: List<PhoneticDTO>,
    val sourceUrls: List<String>,
    val word: String
)