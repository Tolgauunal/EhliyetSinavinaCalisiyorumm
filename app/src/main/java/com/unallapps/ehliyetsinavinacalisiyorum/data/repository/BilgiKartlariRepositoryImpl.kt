package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.BilgiKartlariEntity
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class BilgiKartlariRepositoryImpl @Inject constructor(val firestore: FirebaseFirestore) : BilgiKartlariRepository {
    override suspend fun getKonu(konuAdi: String): List<BilgiKartlariEntity> {
        val bilgiKartlariEntity = mutableListOf<BilgiKartlariEntity>()
        try {
            firestore.collection(konuAdi).get().await().map {
                val result = it.toObject(BilgiKartlariEntity::class.java)
                bilgiKartlariEntity.add(result)
            }
        } catch (e: FirebaseFirestoreException) {
            Log.d("error", "$e")
        }
        return bilgiKartlariEntity

    }

}