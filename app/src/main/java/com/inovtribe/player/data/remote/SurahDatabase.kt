package com.inovtribe.player.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.inovtribe.player.data.entities.Quran
import com.inovtribe.player.utils.Constants.SURAH_COLLECTION
import kotlinx.coroutines.tasks.await


class SurahDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val surahCollection = firestore.collection(SURAH_COLLECTION)

    suspend fun getAllSurahs():List<Quran>{
        return try {
            surahCollection.get().await().toObjects(Quran::class.java)

        }
        catch (e: Exception){
            emptyList()
        }

    }
}