package com.example.pc02_moviles_22200125_22200111.ui.team_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.pc02_moviles_22200125_22200111.data.Team

@Composable
fun TeamListScreen(
    onAddTeam: () -> Unit,
    viewModel: TeamListViewModel = hiltViewModel()
) {
    val teams by viewModel.teams.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddTeam) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(teams) { team ->
                TeamCard(team = team)
            }
        }
    }
}

@Composable
fun TeamCard(team: Team) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = team.crestUrl,
                contentDescription = "Insignia de ${team.name}",
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = team.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Fundado en: ${team.foundationYear}", fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Títulos: ${team.titles}", fontSize = 14.sp)
            }
        }
    }
}