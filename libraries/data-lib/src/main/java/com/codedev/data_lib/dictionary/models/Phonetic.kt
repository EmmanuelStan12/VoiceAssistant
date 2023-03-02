package com.codedev.data_lib.dictionary.models

import com.codedev.api_lib.dictionary.models.LicenseDTO
import com.codedev.api_lib.dictionary.models.PhoneticDTO
import com.codedev.room_lib.dictionary.models.LicenseEntity
import com.codedev.room_lib.dictionary.models.PhoneticEntity

data class Phonetic(
    val audio: String,
    val sourceUrl: String,
    val text: String
) {

    companion object {
        fun fromDTO(dto: PhoneticDTO) = Phonetic(
            audio = dto.audio,
            sourceUrl = dto.sourceUrl,
            text = dto.text
        )

        fun fromEntity(entity: PhoneticEntity) = Phonetic (
            audio = entity.audio ?: "",
            sourceUrl = entity.sourceUrl ?: "",
            text = entity.text ?: "",
        )
    }
}

fun Phonetic.toDBEntity() = PhoneticEntity(
    audio = audio,
    sourceUrl = sourceUrl,
    text = text
)

fun PhoneticDTO.toDBEntity() = PhoneticEntity(
    audio = audio,
    sourceUrl = sourceUrl,
    text = text
)