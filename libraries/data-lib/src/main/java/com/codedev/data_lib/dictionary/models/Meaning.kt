package com.codedev.data_lib.dictionary.models

import com.codedev.api_lib.dictionary.models.MeaningDTO
import com.codedev.room_lib.dictionary.models.MeaningEntity
import com.codedev.room_lib.dictionary.models.MeaningWithDefinitionEntity


data class Meaning(
    val antonyms: List<String>,
    val definitions: List<Definition>,
    val partOfSpeech: String,
    val synonyms: List<String>
) {
    fun Meaning.toDBEntity(): MeaningEntity {
        return MeaningEntity(
            partOfSpeech = partOfSpeech,
            synonyms = synonyms.joinToString { "," },
            antonyms = antonyms.joinToString { "," }
        )
    }

    fun MeaningDTO.toDBEntity() = MeaningEntity(
        partOfSpeech = partOfSpeech,
        synonyms = synonyms.joinToString { "," },
        antonyms = antonyms.joinToString { "," }
    )

    companion object {
        fun fromDTO(dto: MeaningDTO) = Meaning(
            antonyms = dto.antonyms,
            synonyms = dto.synonyms,
            definitions = dto.definitions.map (Definition::fromDTO),
            partOfSpeech = dto.partOfSpeech
        )

        fun fromEntity(entity: MeaningWithDefinitionEntity) = Meaning(
            antonyms = entity.meaning.antonyms?.split(",") ?: emptyList(),
            definitions = entity.definitionEntities.map { Definition.fromEntity(it) },
            partOfSpeech = entity.meaning.partOfSpeech ?: "",
            synonyms = entity.meaning.synonyms?.split(",") ?: emptyList()
        )
    }
}