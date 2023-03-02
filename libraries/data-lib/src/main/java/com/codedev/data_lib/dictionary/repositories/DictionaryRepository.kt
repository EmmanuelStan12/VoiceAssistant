package com.codedev.data_lib.dictionary.repositories

import com.codedev.api_lib.dictionary.DictionaryService
import com.codedev.api_lib.dictionary.models.WordDTO
import com.codedev.api_lib.utils.Either
import com.codedev.data_lib.dictionary.models.Word
import com.codedev.data_lib.dictionary.models.toDBEntity
import com.codedev.data_lib.util.Resource
import com.codedev.data_lib.util.Status
import com.codedev.room_lib.dictionary.DictionaryDao
import com.codedev.room_lib.dictionary.models.WordEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DictionaryRepository(
    private val dictionaryService: DictionaryService,
    private val dictionaryDao: DictionaryDao
): IDictionaryRepository {

    override fun getWord(word: String): Flow<Resource<List<Word>>> = flow {
        emit(Resource.Loading())

        val entityResponse = dictionaryDao.getWord(word)
        if (entityResponse.isNotEmpty()){
            emit(Resource.Success(data = entityResponse.map {
                Word.fromEntity(it)
            }))
            return@flow
        }
        when(val response = dictionaryService.searchWord(word)) {
            is Either.Error -> emit(Resource.Error(response.error.message ?: ""))
            is Either.Response -> {
                response.response.map { insertWordDTOs(it) }
                val result = dictionaryDao.getWord(word)
                emit(Resource.Success(data = result.map {
                    Word.fromEntity(it)
                }))
            }
        }
    }

    private suspend fun insertWordDTOs(wordDTO: WordDTO) {
        val word = Word.fromDTO(wordDTO)

        val (license, meanings, _, phonetics, _, _, _) = word

        val wordId = dictionaryDao.insert(word.toDBEntity()).toInt()

        dictionaryDao.insert(license.toDBEntity().copy(wordId = wordId))

        phonetics.map {
            dictionaryDao.insert(it.toDBEntity().copy(wordId = wordId))
        }

        meanings.map { meaning ->
            val meaningId = dictionaryDao.insert(meaning.toDBEntity().copy(wordId = wordId)).toInt()

            meaning.definitions.map { definition ->
                dictionaryDao.insert(definition.toDBEntity().copy(meaningId = meaningId))
            }
        }
    }

    override suspend fun insertWord(word: Word) {

    }
}