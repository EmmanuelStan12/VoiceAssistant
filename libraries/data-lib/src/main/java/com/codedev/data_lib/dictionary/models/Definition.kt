package com.codedev.data_lib.dictionary.models

import com.codedev.api_lib.dictionary.models.DefinitionDTO
import com.codedev.room_lib.dictionary.models.DefinitionEntity

data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
) {

    fun Definition.toDBEntity(): DefinitionEntity {
        return DefinitionEntity(
            definitionId = null,
            meaningId = null,
            definition = definition,
            synonyms = synonyms.joinToString { "," },
            antonyms = antonyms.joinToString { "," },
            example = example
        )
    }

    fun DefinitionDTO.toDBEntity(): DefinitionEntity {
        return DefinitionEntity(
            definitionId = null,
            meaningId = null,
            definition = definition,
            synonyms = synonyms.joinToString { "," },
            antonyms = antonyms.joinToString { "," },
            example = example
        )
    }

    companion object {
        fun fromDTO(dto: DefinitionDTO): Definition {
            return Definition(
                antonyms = dto.antonyms,
                definition = dto.definition,
                example = dto.example,
                synonyms = dto.synonyms
            )
        }

        fun fromEntity(entity: DefinitionEntity): Definition {
            return Definition(
                antonyms = entity.antonyms?.split(",") ?: emptyList(),
                definition = entity.definition ?: "",
                example = entity.example ?: "",
                synonyms = entity.synonyms?.split(",") ?: emptyList()
            )
        }
    }

}