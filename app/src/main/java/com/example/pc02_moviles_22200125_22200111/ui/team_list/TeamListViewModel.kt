package com.example.pc02_moviles_22200125_22200111.ui.team_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pc02_moviles_22200125_22200111.data.Team
import com.example.pc02_moviles_22200125_22200111.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TeamListViewModel @Inject constructor(
    teamRepository: TeamRepository
) : ViewModel() {

    val teams: StateFlow<List<Team>> = teamRepository.getTeams()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}