package com.codedev.room_lib.dictionary.models

import androidx.room.*

@Entity
data class LicenseEntity(
    @PrimaryKey(autoGenerate = true)
    val licenseId: Int? = null,
    val wordId: Int? = null,
    val name: String? = null,
    val url: String? = null
)

@Entity(
    foreignKeys = [ForeignKey(entity = WordEntity::class,
    parentColumns = ["wordId"], childColumns = ["licenseId"])]
)
data class WordWithLicenses(
    @Embedded
    val word: WordEntity,
    @Relation(
        parentColumn = "wordId",
        entityColumn = "licenseId"
    )
    val phonetics: List<PhoneticEntity>
)