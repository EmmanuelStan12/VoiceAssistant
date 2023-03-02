package com.codedev.room_lib.dictionary.models

import androidx.room.*

@Entity
data class DefinitionEntity(
    @PrimaryKey(autoGenerate = true)
    val definitionId: Int? = null,
    val meaningId: Int? = null,
    val definition: String? = null,
    val synonyms: String? = null,
    val antonyms: String? = null,
    val example: String? = null
)

data class MeaningWithDefinitionEntity(
    @Embedded
    val meaning: MeaningEntity,
    @Relation(
        parentColumn = "meaningId",
        entityColumn = "meaningId",
        entity = DefinitionEntity::class
    )
    val definitionEntities: List<DefinitionEntity>
)