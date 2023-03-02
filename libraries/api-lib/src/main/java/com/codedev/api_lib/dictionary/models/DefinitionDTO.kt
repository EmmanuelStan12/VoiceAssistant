package com.codedev.api_lib.dictionary.models

data class DefinitionDTO(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
)