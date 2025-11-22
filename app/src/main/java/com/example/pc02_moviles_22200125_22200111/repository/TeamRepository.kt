package com.example.pc02_moviles_22200125_22200111.repository

import com.example.pc02_moviles_22200125_22200111.data.Team
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepository @Inject constructor(private val firestore: FirebaseFirestore) {

    suspend fun addTeam(team: Team): Result<Unit> {
        return try {
            val document = firestore.collection("teams").document()
            val teamWithId = team.copy(id = document.id)
            document.set(teamWithId).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getTeams(): Flow<List<Team>> = callbackFlow {
        val subscription = firestore.collection("teams")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    val teams = snapshot.toObjects(Team::class.java)
                    trySend(teams)
                }
            }
        awaitClose { subscription.remove() }
    }
}