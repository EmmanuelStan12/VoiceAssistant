package com.codedev.data_lib.dictionary.models

import com.codedev.api_lib.dictionary.models.PhoneticDTO
import com.codedev.api_lib.dictionary.models.WordDTO
import com.codedev.room_lib.dictionary.models.PhoneticEntity
import com.codedev.room_lib.dictionary.models.WordEntity
import com.codedev.room_lib.dictionary.models.WordWithProperties

data class Word(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String,
    val origin: String?
) {


    companion object {
        fun fromDTO(dto: WordDTO) = Word (
            meanings = dto.meanings.map { Meaning.fromDTO(it) },
            license = License.fromDTO(dto.license),
            phonetic = dto.phonetic,
            phonetics = dto.phonetics.map{ Phonetic.fromDTO(it) },
            sourceUrls = dto.sourceUrls,
            word = dto.word,
            origin = null
        )

        fun fromEntity(entity: WordWithProperties) = Word (
            sourceUrls = entity.word.sourceUrls?.split(",") ?: emptyList(),
            word = entity.word.word,
            origin = null,
            phonetic = entity.word.phoneticSymbol,
            license = License.fromEntity(entity.license),
            meanings = entity.meanings.map { Meaning.fromEntity(it) },
            phonetics = entity.phonetics.map { Phonetic.fromEntity(it) }
        )
    }
}

fun WordDTO.toDBEntity() = WordEntity(
    word = word,
    phoneticSymbol = phonetic,
    origin = null,
    sourceUrls = sourceUrls.joinToString { "," }
)

fun Word.toDBEntity() = WordEntity(
    word = word,
    phoneticSymbol = phonetic,
    origin = origin,
    sourceUrls = sourceUrls.joinToString { "," }
)