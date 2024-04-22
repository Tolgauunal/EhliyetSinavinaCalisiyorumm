package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import javax.inject.Inject

class TestAddRepositoryImpl @Inject constructor(private val firebaseFirestore: FirebaseFirestore) : TestAddRepository {
    override suspend fun addTest(test: TestlerEntity) {
        firebaseFirestore.collection("Motor").document(test.idTest.toString()).set(test)
    }
}