package com.codedev.room_lib.dictionary.models

import androidx.room.*

@Entity
data class PhoneticEntity(
    @PrimaryKey(autoGenerate = true)
    val phoneticId: Int? = null,
    val wordId: Int? = null,
    val audio: String? = null,
    val sourceUrl: String? = null,
    val text: String? = null
)

@Entity(
    foreignKeys = [ForeignKey(entity = WordEntity::class,
    parentColumns = ["wordId"], childColumns = ["phoneticId"])]
)
data class WordWithPhonetics(
    @Embedded
    val word: WordEntity,
    @Relation(
        parentColumn = "wordId",
        entityColumn = "phoneticId"
    )
    val phonetics: List<PhoneticEntity>
)