package com.codedev.data_lib.dictionary.repositories

import com.codedev.api_lib.utils.Either
import com.codedev.data_lib.dictionary.models.Word
import com.codedev.data_lib.util.Resource
import com.codedev.data_lib.util.Status
import com.codedev.room_lib.dictionary.models.WordEntity
import kotlinx.coroutines.flow.Flow

interface IDictionaryRepository {

    fun getWord(word: String): Flow<Resource<List<Word>>>

    suspend fun insertWord(word: Word)

}