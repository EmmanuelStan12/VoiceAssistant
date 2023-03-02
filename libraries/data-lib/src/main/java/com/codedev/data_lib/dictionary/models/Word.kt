package com.codedev.data_lib.dictionary.models

import com.codedev.api_lib.dictionary.models.PhoneticDTO
import com.codedev.api_lib.dictionary.models.WordDTO
import com.codedev.room_lib.dictionary.models.PhoneticEntity
import com.codedev.room_lib.dictionary.models.WordEntity

data class Word(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String,
    val origin: String?
) {
    fun Word.toDBEntity() = WordEntity(
        word = word,
        phoneticSymbol = phonetic,
        origin = origin,
        sourceUrls = sourceUrls.joinToString { "," }
    )

    fun WordDTO.toDBEntity() = WordEntity(
        word = word,
        phoneticSymbol = phonetic,
        origin = origin,
        sourceUrls = sourceUrls.joinToString { "," }
    )

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

        fun fromEntity(entity: WordEntity) = WordEntity (
            sourceUrls = entity.sourceUrls,
            word = entity.word,
            origin = null,
            phoneticSymbol = entity.phoneticSymbol
        )
    }
}