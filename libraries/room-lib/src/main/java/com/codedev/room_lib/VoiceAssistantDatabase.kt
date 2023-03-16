package com.codedev.room_lib

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codedev.room_lib.dictionary.DictionaryDao
import com.codedev.room_lib.dictionary.models.*

@Database(
    entities = [
        DefinitionEntity::class,
        LicenseEntity::class,
        MeaningEntity::class,
        PhoneticEntity::class,
        WordEntity::class
    ],
    version = 1
)
abstract class VoiceAssistantDatabase: RoomDatabase() {

    abstract val dictionaryDao: DictionaryDao

    companion object {
        private var instance: VoiceAssistantDatabase? = null

        fun getInstance(ctx: Context): VoiceAssistantDatabase {
            if (instance == null) {
                synchronized(VoiceAssistantDatabase::class) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            ctx,
                            VoiceAssistantDatabase::class.java,
                            "voice_assistant_db"
                        ).build()
                    }
                }
            }
            return instance!!
        }
    }
}