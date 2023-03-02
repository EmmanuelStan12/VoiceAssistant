package com.codedev.room_lib.dictionary.models

import androidx.room.*

@Entity
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val wordId: Int? = null,
    val word: String,
    val phoneticSymbol: String,
    val origin: String?,
    val sourceUrls: String? = null
)


data class WordWithProperties(
    @Embedded
    val word: WordEntity,
    @Relation(
        parentColumn = "wordId",
        entityColumn = "wordId",
        entity = PhoneticEntity::class
    )
    val phonetics: List<PhoneticEntity>,
    @Relation(
        parentColumn = "wordId",
        entityColumn = "wordId",
        entity = LicenseEntity::class
    )
    val license: LicenseEntity,
    @Relation(
        parentColumn = "wordId",
        entityColumn = "wordId",
        entity = MeaningEntity::class
    )
    val meanings: List<MeaningWithDefinitionEntity>,
)
