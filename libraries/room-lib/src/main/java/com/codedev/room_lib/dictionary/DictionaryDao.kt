package com.codedev.room_lib.dictionary

import androidx.room.*
import com.codedev.room_lib.dictionary.models.WordWithProperties

@Dao
interface DictionaryDao {

    @Transaction
    @Query("SELECT * FROM Word")
    suspend fun getAllWords(): List<WordWithProperties>

    @Transaction
    @Query("SELECT * FROM Word LIMIT :size")
    suspend fun getWords(size: Int): List<WordWithProperties>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun <T> insert(data: T): Long
}