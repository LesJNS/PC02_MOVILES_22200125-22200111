package com.example.pc02_moviles_22200125_22200111.ui.team_registration

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TeamRegistrationScreen(
    onTeamRegistered: () -> Unit,
    viewModel: TeamRegistrationViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = viewModel.name,
            onValueChange = { viewModel.name = it },
            label = { Text("Nombre del Equipo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.foundationYear,
            onValueChange = { viewModel.foundationYear = it },
            label = { Text("Año de Fundación") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.titles,
            onValueChange = { viewModel.titles = it },
            label = { Text("Número de Títulos") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.crestUrl,
            onValueChange = { viewModel.crestUrl = it },
            label = { Text("URL de la Insignia") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.onSaveTeam(onSuccess = onTeamRegistered)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = viewModel.name.isNotBlank() && viewModel.foundationYear.isNotBlank() && viewModel.titles.isNotBlank() && viewModel.crestUrl.isNotBlank()
        ) {
            Text("Guardar")
        }
    }
}