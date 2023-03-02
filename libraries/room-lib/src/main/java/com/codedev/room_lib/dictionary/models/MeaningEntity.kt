package com.codedev.room_lib.dictionary.models

import androidx.room.*

@Entity
data class MeaningEntity(
    @PrimaryKey(autoGenerate = true)
    val meaningId: Int? = null,
    val wordId: Int? = null,
    val partOfSpeech: String? = null,
    val synonyms: String? = null,
    val antonyms: String? = null
)

@Entity(
    foreignKeys = [ForeignKey(entity = WordEntity::class,
    parentColumns = ["wordId"], childColumns = ["meaningId"])]
)
data class WordWithMeaning(
    @Embedded
    val word: WordEntity,
    @Relation(
        parentColumn = "wordId",
        entityColumn = "meaningId"
    )
    val meanings: List<MeaningWithDefinitionEntity>
)