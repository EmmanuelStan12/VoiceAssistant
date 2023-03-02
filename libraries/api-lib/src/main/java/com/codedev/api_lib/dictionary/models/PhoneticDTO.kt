package com.codedev.api_lib.dictionary.models

data class PhoneticDTO(
    val audio: String,
    val license: LicenseDTO,
    val sourceUrl: String,
    val text: String
)