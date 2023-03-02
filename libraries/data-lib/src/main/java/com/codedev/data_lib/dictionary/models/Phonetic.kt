package com.codedev.data_lib.dictionary.models

import com.codedev.api_lib.dictionary.models.LicenseDTO
import com.codedev.api_lib.dictionary.models.PhoneticDTO
import com.codedev.room_lib.dictionary.models.LicenseEntity
import com.codedev.room_lib.dictionary.models.PhoneticEntity

data class Phonetic(
    val audio: String,
    val license: License,
    val sourceUrl: String,
    val text: String
) {
    fun Phonetic.toDBEntity() = Phonetic(
        audio = audio,
        license = license,
        sourceUrl = sourceUrl,
        text = text
    )

    fun PhoneticDTO.toDBEntity() = PhoneticEntity(
        audio = audio,
        sourceUrl = sourceUrl,
        text = text
    )

    companion object {
        fun fromDTO(dto: PhoneticDTO) = Phonetic(
            audio = dto.audio,
            license = License.fromDTO(dto.license),
            sourceUrl = dto.sourceUrl,
            text = dto.text
        )

        fun fromEntity(entity: PhoneticEntity) = PhoneticEntity(
            audio = entity.audio,
            sourceUrl = entity.sourceUrl,
            text = entity.text
        )
    }
}