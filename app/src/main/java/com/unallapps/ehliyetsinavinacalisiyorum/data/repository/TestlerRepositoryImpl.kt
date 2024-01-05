package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerListState
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class TestlerRepositoryImpl @Inject constructor(private val firestore: FirebaseFirestore):TestlerRepository{
    override suspend fun getTest(): TestlerListState {
        val querySnapshot = firestore.collection("Testler").get().await()
        return if (querySnapshot.isEmpty) TestlerListState.Empty
        else TestlerListState.Result(querySnapshot.toObjects(TestlerEntity::class.java))
    }

}