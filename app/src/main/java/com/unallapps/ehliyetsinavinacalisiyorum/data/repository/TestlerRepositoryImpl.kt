package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.storage.FirebaseStorage
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject

class TestlerRepositoryImpl @Inject constructor(private val firestore: FirebaseFirestore,
    private val firebaseStorage: FirebaseStorage) : TestlerRepository {
    override suspend fun getTestlerData(dersAdi: String, testNum: Int): List<TestlerEntity> {
        val testlerEntity = mutableListOf<TestlerEntity>()
        try {
            firestore.collection(dersAdi).whereGreaterThanOrEqualTo("idTest", testNum).get().await().map {
                val result = it.toObject(TestlerEntity::class.java)
                testlerEntity.add(result)
            }
        } catch (e: FirebaseFirestoreException) {
            Log.d("error", "$e")
        }
        return testlerEntity
    }
}