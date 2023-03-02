package com.codedev.data_lib.dictionary.models

import com.codedev.api_lib.dictionary.models.LicenseDTO
import com.codedev.room_lib.dictionary.models.LicenseEntity


data class License(
    val name: String,
    val url: String
) {

    companion object {
        fun fromDTO(dto: LicenseDTO): License {
            return License(
                name = dto.name,
                url = dto.url
            )
        }

        fun fromEntity(entity: LicenseEntity): License {
            return License(
                name = entity.name ?: "",
                url = entity.url ?: ""
            )
        }
    }
}

fun License.toDBEntity(): LicenseEntity {
    return LicenseEntity(
        name = name,
        url = url
    )
}

fun LicenseDTO.toDBEntity(): LicenseEntity {
    return LicenseEntity(
        name = name,
        url = url
    )
}