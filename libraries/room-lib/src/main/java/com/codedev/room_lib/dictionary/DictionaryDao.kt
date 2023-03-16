package com.codedev.room_lib.dictionary

import androidx.room.*
import com.codedev.room_lib.dictionary.models.*

@Dao
interface DictionaryDao {

    @Transaction
    @Query("SELECT * FROM WordEntity")
    suspend fun getAllWords(): List<WordWithProperties>

    @Transaction
    @Query("SELECT * FROM WordEntity LIMIT :size")
    suspend fun getWords(size: Int): List<WordWithProperties>

    @Transaction
    @Query("SELECT * FROM WordEntity WHERE word = :word")
    suspend fun getWord(word: String): List<WordWithProperties>

    @Transaction
    @Query("SELECT * FROM MeaningEntity WHERE wordId = :wordId")
    suspend fun getMeaning(wordId: Int): List<MeaningEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(data: WordEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeaning(data: MeaningEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLicense(data: LicenseEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhonetic(data: PhoneticEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDefinition(data: DefinitionEntity): Long
}