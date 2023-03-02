package com.codedev.api_lib.dictionary.models

data class MeaningDTO(
    val antonyms: List<String>,
    val definitions: List<DefinitionDTO>,
    val partOfSpeech: String,
    val synonyms: List<String>
)