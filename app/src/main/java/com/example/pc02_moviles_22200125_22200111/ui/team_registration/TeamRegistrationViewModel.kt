package com.example.pc02_moviles_22200125_22200111.ui.team_registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pc02_moviles_22200125_22200111.data.Team
import com.example.pc02_moviles_22200125_22200111.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamRegistrationViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    var name by mutableStateOf("")
    var foundationYear by mutableStateOf("")
    var titles by mutableStateOf("")
    var crestUrl by mutableStateOf("")

    fun onSaveTeam(onSuccess: () -> Unit) {
        viewModelScope.launch {
            val team = Team(
                name = name,
                foundationYear = foundationYear,
                titles = titles,
                crestUrl = crestUrl
            )
            teamRepository.addTeam(team).onSuccess {
                onSuccess()
            }
        }
    }
}