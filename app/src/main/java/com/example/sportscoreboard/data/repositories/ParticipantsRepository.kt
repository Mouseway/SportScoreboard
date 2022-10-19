package com.example.sportscoreboard.data.repositories

import com.example.sportscoreboard.domain.ResultState
import com.example.sportscoreboard.data.remote.apiDescriptions.ParticipantsApiDescription
import com.example.sportscoreboard.domain.Participant
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ParticipantsRepository(private val apiDescription: ParticipantsApiDescription) {

    fun getFilteredParticipants(text: String): Flow<ResultState<List<Participant>>> {
        return flow {
            emit(ResultState.Loading(isLoading = true))
            val response = apiDescription.getFilteredParticipants(text)
            if(response.isSuccessful){
                emit(ResultState.Success(response.body()))
            }else{
                val errorMessage = response.message()
                emit(ResultState.Error(errorMessage, true))
            }
        }
    }
}